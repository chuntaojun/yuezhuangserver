package com.yueserver.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liaochuntao on 17-7-18.
 */

@Controller
public class JspViewController {

    @RequestMapping(value = "/yue/uploads/{account}")
    public  String saveProduct(HttpServletRequest request){
        return "commodity";
    }

    @RequestMapping(value = "/admin/show")
    public String showIndex(HttpServletRequest request){
        return "index";
    }

    @RequestMapping(value = "/yue/query/{account}")
    public String queryData(HttpServletRequest request){
        return "tables";
    }

    @RequestMapping(value = "/yue/report/{account}")
    public String reportData(HttpServletRequest request){
        return "charts";
    }

    @RequestMapping(value = "/admin/businessmen")
    public String perosnalCenter(HttpServletRequest request){
        return "personal";
    }

    @RequestMapping(value = "/admin/hot")
    public String hot(HttpServletRequest request) {
        return "hot";
    }

    @RequestMapping(value = "/admin/notic")
    public String notic() {
        return "notic";
    }

    @RequestMapping(value = "/admin/superhuman")
    public String superhuman() {
        return "superhuman";
    }

    @RequestMapping(value = "/registered")
    public String registeredUser(){
        return "registered";
    }

    @RequestMapping(value = "/retrievePassword")
    public String retrievePassword(HttpServletRequest request){
        return "/retrievepas";
    }

}