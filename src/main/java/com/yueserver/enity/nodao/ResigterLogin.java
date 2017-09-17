package com.yueserver.enity.nodao;

/**
 * 用于商家注册临时对象,进行数据传输
 */
public class ResigterLogin {

    private String mctaccount;
    private String password;
    private String email;
    private String mctname;

    public String getMctaccount() {
        return mctaccount;
    }

    public void setMctaccount(String mctaccount) {
        this.mctaccount = mctaccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMctname() {
        return mctname;
    }

    public void setMctname(String mctname) {
        this.mctname = mctname;
    }
}
