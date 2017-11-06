package com.yueserver.service.search;

import com.yueserver.enity.noenity.ListingDocument;
import com.yueserver.service.SearchEngineBasicInterface;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * solr 搜索引擎的基础功能-->索引的建立与用户搜索结果的响应
 */
@Service("SolrSearch")
public class SolrSearchEngineBasic implements SearchEngineBasicInterface {

    protected CloudSolrClient solrClient = null;

    public SolrSearchEngineBasic(Map<String, Object> serverParams) {
        try {
            //获取zookeeper设置
            String zkHost = serverParams.get("zkHost").toString();
            //读取solr Collection 文档的配置
            String collection = serverParams.get("collection").toString();
            //根据上述配置，初始化 CloudSolrClient
            solrClient = new CloudSolrClient.Builder().withZkHost(zkHost).build();
            solrClient.setDefaultCollection(collection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭CloudSolrClient的连接
     */
    public void cleanup() {
        if (solrClient != null) {
            try {
                solrClient.close();
                solrClient = null;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                solrClient = null;
            }
        }
    }

    /**
     * 实现solr的索引接口
     * @param documents
     * @param indexParams
     * @return
     */
    @Override
    public String index(List<ListingDocument> documents, Map<String, Object> indexParams) {
        UpdateResponse response = null;
        try {
            for (ListingDocument listingDocument : documents) {
                SolrInputDocument sid = new SolrInputDocument();
                sid.addField("listing_id", listingDocument.getListing_id());
                sid.addField("listing_title", listingDocument.getListing_title());
                sid.addField("category_id", listingDocument.getCategory_id());
                sid.addField("category_name", listingDocument.getCategory_name());
                solrClient.add(sid);
            }
            response = solrClient.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    /**
     * 实现solr的查询接口
     * 将用户的搜索请求转换成SolrQuery
     * @param queryParams
     * @return
     */
    @Override
    public String query(Map<String, Object> queryParams) {
        QueryResponse response = null;
        try {
            String query = queryParams.get("query").toString();
            String[] terms = query.split("\\s+");
            StringBuffer sbQuery = new StringBuffer();
            for (String term : terms) {
                if (sbQuery.length() == 0)
                    sbQuery.append(term);
                else
                    sbQuery.append("AND").append(term);
            }
            String[] fields = (String[]) queryParams.get("fields");
            StringBuffer sbQf =  new StringBuffer();
            for (String field : fields) {
                if (sbQf.length() == 0)
                    sbQf.append(field);
                else
                    sbQf.append(" ").append(field);
            }
            int start = (int)queryParams.get("start");
            int rows = (int)queryParams.get("rows");
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setParam("defType", "edismax");
            solrQuery.set("q", sbQuery.toString());
            solrQuery.set("qf", sbQf.toString());
            solrQuery.set("start", start);
            solrQuery.set("rows", rows);

            //获取查询结果
            response = solrClient.query(solrQuery);
            SolrDocumentList solrDocuments = response.getResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
