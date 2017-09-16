package com.yueserver.adaper.conver.impl;

import com.yueserver.adaper.conver.UrlInterface;

public class MctPic implements UrlInterface {

    private String PRDPIC_URL_TEST = "http://127.0.0.1:8080/file";
    private String PRDPIC_URL = "http://120.25.201.1:8080/file";

    public String RsourcesHttpUrl(String filename, String mctinfo){
        return PRDPIC_URL_TEST + "/merchant/images/" + mctinfo + "/" + filename;
    }

    @Override
    public String BrandReourcesHttpUrl(String filename, String brdName) {
        return PRDPIC_URL_TEST + "/brdLogo/" + brdName + "/" + filename;
    }

}
