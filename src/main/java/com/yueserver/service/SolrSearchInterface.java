package com.yueserver.service;

import com.yueserver.enity.noenity.ResultBean;

public interface SolrSearchInterface {

    ResultBean<String> getSearchAnsForProduct(int start, int rows, String params);

}
