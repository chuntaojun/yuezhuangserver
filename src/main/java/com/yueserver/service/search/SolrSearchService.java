package com.yueserver.service.search;

import com.yueserver.enity.noenity.ResultBean;
import com.yueserver.service.SearchEngineBasicInterface;
import com.yueserver.service.SolrSearchInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("SolrSearchService")
public class SolrSearchService implements SolrSearchInterface {

    @Autowired
    @Resource(name = "SolrSearchEngine")
    private SearchEngineBasicInterface searchEngineBasicInterface;

    @Override
    public ResultBean<String> getSearchAnsForProduct(int start, int rows, String params) {
        ResultBean<String> searchResult = new ResultBean<>();
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("query", params);
        queryParams.put("fields", new String[] {"listing_id", "category_name"});
        queryParams.put("start", start);
        queryParams.put("rows", rows);
        searchResult.setData(searchEngineBasicInterface.query(queryParams));
        return searchResult;
    }
}
