package com.yueserver.adaper.conver.impl;

import com.yueserver.adaper.conver.UrlInterface;

public class AdminVid implements UrlInterface {

    private String PRDVID_URL_TEST = "http://127.0.0.1:8080/file";
    private String PRDVID_URL = "http://120.25.201.1:8080/file";

    public String RsourcesHttpUrl(String filename, String none) {
        return PRDVID_URL_TEST + "/admin/videos/" + filename;
    }

    @Override
    public String BrandReourcesHttpUrl(String filename, String brdName) {
        return null;
    }

}