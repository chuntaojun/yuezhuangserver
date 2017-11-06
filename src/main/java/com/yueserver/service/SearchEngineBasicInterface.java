package com.yueserver.service;

import com.yueserver.enity.noenity.ListingDocument;

import java.util.List;
import java.util.Map;

/**
 * solr 搜索引擎的索引建立与查询接口
 */
public interface SearchEngineBasicInterface {

    String index(List<ListingDocument> documents, Map<String, Object> indexParams);
    String query(Map<String, Object> queryParams);

}
