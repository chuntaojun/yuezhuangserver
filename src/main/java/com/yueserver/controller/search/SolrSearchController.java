package com.yueserver.controller.search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 搜索引擎的controller
 * 开放此API用于用户搜索，同时避免直接访问solr搜索引擎所带来的安全问题
 */
@Controller
@RequestMapping(value = "/app/search")
public class SolrSearchController {

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getParams(String params, String id) {
        return null;
    }

}
