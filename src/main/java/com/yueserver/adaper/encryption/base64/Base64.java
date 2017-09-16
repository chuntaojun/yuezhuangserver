package com.yueserver.adaper.encryption.base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Base64 {

    /**
     * 用户名base64加密处理
     * @param user_name
     * @return
     */
    public String Base64Encode(String user_name) {
        byte[] b = null;
        String s = null;
        try {
            b = user_name.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    public String Base64Decode(String base64) {
        byte[] bytes = null;
        String s = null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            bytes = decoder.decodeBuffer(base64);
            s = new String(bytes, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
