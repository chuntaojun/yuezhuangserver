package com.yueserver.controller.search;

import com.yueserver.service.SolrSearchInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * 搜索引擎的controller
 * 开放此API用于用户搜索，同时避免直接访问solr搜索引擎所带来的安全问题
 */
@Controller
@RequestMapping(value = "/app/search")
public class SolrSearchController {

    @Autowired
    @Resource(name = "SolrSearchService")
    private SolrSearchInterface solrSearchInterface;

    @ResponseBody
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getParams(int start, int rows, String params) {
        return solrSearchInterface.getSearchAnsForProduct(start, rows, params).getData();
    }

}
