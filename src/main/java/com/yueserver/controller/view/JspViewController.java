package com.yueserver.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liaochuntao on 17-7-18.
 */

@Controller
public class JspViewController {

    @RequestMapping(value = "/yue/uploads/user/{account}")
    public  String UploadBrandedItems(){
        return "UploadBrandedItems";
    }

    @RequestMapping(value = "/yue/query/user/{account}")
    public String ManageBrdPrd(){
        return "ManageBrdPrd";
    }

    @RequestMapping(value = "/yue/report/user/{account}")
    public String DataReport(){
        return "DataReport";
    }

    @RequestMapping(value = "/yue/issue/user/{account}")
    public String Issue() {
        return "PushFeedBack";
    }

    @RequestMapping(value = "/admin/show")
    public String SalesData(){
        return "SalesData";
    }

    @RequestMapping(value = "/admin/merchant")
    public String perosnalCenter(){
        return "ManageMerchants";
    }

    @RequestMapping(value = "/admin/notice")
    public String InformationRelease() {
        return "InformationRelease";
    }

    @RequestMapping(value = "/admin/sportInfo")
    public String ActivityInformation() {
        return "ActivityInformation";
    }

    @RequestMapping(value = "/admin/deal/feedback")
    public String FeedBack() {
        return "DealFeedBack";
    }

    @RequestMapping(value = "/registered")
    public String registeredUser(){
        return "Registered";
    }

    @RequestMapping(value = "/retrievePassword")
    public String retrievePassword(){
        return "RetrievepasPassword";
    }

}