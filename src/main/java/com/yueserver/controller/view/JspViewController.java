package com.yueserver.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liaochuntao on 17-7-18.
 */

@Controller
public class JspViewController {

    @RequestMapping(value = {"/yue/uploads/user/{account}", "/yue/uploads/admin"})
    public  String UploadBrandedItems(){
        return "UploadBrandedItems";
    }

    @RequestMapping(value = {"/yue/query/user/{account}", "/yue/query/admin"})
    public String ManageBrdPrd(){
        return "ManageBrdPrd";
    }

    @RequestMapping(value = {"/yue/report/user/{account}", "/yue/report/admin"})
    public String DataReport(){
        return "DataReport";
    }

    @RequestMapping(value = "/yue/issue/user/{account}")
    public String Issue() {
        return "PushFeedBack";
    }

    @RequestMapping(value = "/yue/show/admin")
    public String SalesData(){
        return "SalesData";
    }

    @RequestMapping(value = "/yue/merchant/admin")
    public String perosnalCenter(){
        return "ManageMerchants";
    }

    @RequestMapping(value = "/yue/notice/admin")
    public String InformationRelease() {
        return "InformationRelease";
    }

    @RequestMapping(value = {"/yue/sportInfo/admin", "/yue/push/ticket/user/{account}"})
    public String ActivityInformation() {
        return "ActivityInformation";
    }

    @RequestMapping(value = "/yue/deal/feedback/admin")
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