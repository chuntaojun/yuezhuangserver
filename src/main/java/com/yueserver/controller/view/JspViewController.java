package com.yueserver.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liaochuntao on 17-7-18.
 */

@Controller
public class JspViewController {

    @RequestMapping(value = "/yue/uploads/{account}")
    public  String UploadBrandedItems(){
        return "UploadBrandedItems";
    }

    @RequestMapping(value = "/yue/query/{account}")
    public String ManageBrdPrd(){
        return "ManageBrdPrd";
    }

    @RequestMapping(value = "/yue/report/{account}")
    public String DataReport(){
        return "DataReport";
    }

    @RequestMapping(value = "/admin/show")
    public String SalesData(){
        return "SalesData";
    }

    @RequestMapping(value = "/admin/businessmen")
    public String perosnalCenter(){
        return "ManageMerchants";
    }

    @RequestMapping(value = "/admin/notic")
    public String InformationRelease() {
        return "InformationRelease";
    }

    @RequestMapping(value = "/admin/superhuman")
    public String ActivityInformation() {
        return "ActivityInformation";
    }

    @RequestMapping(value = "/feedback")
    public String FeedBack() {
        return "FeedBack";
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