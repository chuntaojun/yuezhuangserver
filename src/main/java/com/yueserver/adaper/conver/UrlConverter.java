package com.yueserver.adaper.conver;

public class UrlConverter {

    private UrlInterface urlInterface;

    public UrlConverter() {}

    public UrlConverter(UrlInterface urlInterface) {
        this.urlInterface = urlInterface;
    }

    public String UrlEncode(String s){
        return "file_" + String.valueOf(s.hashCode());
    }

    public String ReourcesHttpUrl(String filename, String info) {
        return urlInterface.RsourcesHttpUrl(filename, info);
    }

    public String BrandReourcesHttpUrl(String filename, String brdName) {
        return urlInterface.BrandReourcesHttpUrl(filename, brdName);
    }

}
