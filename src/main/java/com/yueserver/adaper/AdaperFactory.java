package com.yueserver.adaper;

import com.yueserver.adaper.conver.JsonConverter;
import com.yueserver.adaper.conver.ListConverter;
import com.yueserver.adaper.conver.UrlConverter;
import com.yueserver.adaper.encryption.base64.Base64;
import com.yueserver.adaper.encryption.mdfive.MD5;

import java.util.HashMap;
import java.util.Map;

public class AdaperFactory {

    //方法缓冲池Map
    Map<String, Object> adaperMap;

    public static AdaperFactory adaperFactory = new AdaperFactory();

    /**
     * 构造函数私有化避免外部进行该对象的实例化
     */
    private AdaperFactory() {
        adaperMap = new HashMap<>();
        LoadCache();
    }

    /**
     * 方法缓存
     */
    protected void LoadCache() {
        //数据加密
        adaperMap.put("md5", new MD5());
        adaperMap.put("base64", new Base64());

        //数据适配
        adaperMap.put("list", new ListConverter());
        adaperMap.put("json", new JsonConverter());
        adaperMap.put("url", new UrlConverter());
    }

    /**
     * 加密方法获取
     * @param encryptionType
     * @return
     * @throws MethodNourtFoundException
     */
    public Object getEncryption(String encryptionType) throws MethodNourtFoundException {
        if (encryptionType.equalsIgnoreCase("md5"))
            return (MD5) adaperMap.get("md5");
        if (encryptionType.equalsIgnoreCase("base64"))
            return (Base64) adaperMap.get("base64");
        throw new MethodNourtFoundException();
    }

    /**
     * 数据适配方法获取
     * @param converType
     * @return
     * @throws MethodNourtFoundException
     */
    public Object getConverter(String converType) throws MethodNourtFoundException {
        if (converType.equalsIgnoreCase("list"))
            return (ListConverter) adaperMap.get("list");
        if (converType.equalsIgnoreCase("json"))
            return (JsonConverter) adaperMap.get("json");
        if (converType.equalsIgnoreCase("url"))
            return (UrlConverter) adaperMap.get("url");
        throw new MethodNourtFoundException();
    }

    /**
     * 本对象单例获取
     * @return
     */
    public static AdaperFactory getSingleAdaperFactory() {
        return adaperFactory;
    }

}
