package com.yueserver.adaper.encryption.mdfive;

import java.security.MessageDigest;

public class MD5 {

    private String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    /**
     * 用户密码MD5加密存储
     * @param user_password
     * @return
     */
    public String Md5Password(String user_password){
        String result = null;
        try{
            MessageDigest md = MessageDigest.getInstance("mdfive");
            result = byteArrayToHexString(md.digest(user_password.getBytes()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 用于MD5加密处理
     * @param b
     * @return
     */
    private String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * 用于MD5加密处理
     * @param b
     * @return
     */
    private String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

}
