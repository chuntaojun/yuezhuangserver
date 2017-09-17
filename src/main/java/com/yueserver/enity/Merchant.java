package com.yueserver.bean;


import java.util.Date;

public class Merchant {

    private int mctno;
    private String mctaccount;
    private String mctpassword;
    private String mctauthcode;
    private Date mcttime;
    private int mctstate;

    public Merchant(){}

    public int getMctno() {
        return mctno;
    }

    public void setMctno(int mctno) {
        this.mctno = mctno;
    }

    public String getMctaccount() {
        return mctaccount;
    }

    public void setMctaccount(String mctaccount) {
        this.mctaccount = mctaccount;
    }

    public String getMctpassword() {
        return mctpassword;
    }

    public void setMctpassword(String mctpassword) {
        this.mctpassword = mctpassword;
    }

    public String getMctauthcode() {
        return mctauthcode;
    }

    public void setMctauthcode(String mctauthcode) {
        this.mctauthcode = mctauthcode;
    }

    public Date getMcttime() {
        return mcttime;
    }

    public void setMcttime(Date mcttime) {
        this.mcttime = mcttime;
    }

    public int getMctstate() {
        return mctstate;
    }

    public void setMctstate(int mctstate) {
        this.mctstate = mctstate;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "mctno=" + mctno +
                ", mctaccount='" + mctaccount + '\'' +
                ", mctpassword='" + mctpassword + '\'' +
                ", mctauthcode='" + mctauthcode + '\'' +
                ", mcttime=" + mcttime +
                ", mctstate=" + mctstate +
                '}';
    }
}
