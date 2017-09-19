package com.yueserver.enity.nodao;

import com.sun.org.glassfish.gmbal.NameValue;

public class MerchanrTicket {

    private String brdName;
    private String prdName;

    @NameValue()
    private int tickNum;
    private String mctname;

    public String getBrdName() {
        return brdName;
    }

    public void setBrdName(String brdName) {
        this.brdName = brdName;
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public int getTickNum() {
        return tickNum;
    }

    public void setTickNum(int tickNum) {
        this.tickNum = tickNum;
    }

    public String getMctname() {
        return mctname;
    }

    @Override
    public String toString() {
        return "MerchanrTicket{" +
                "brdName='" + brdName + '\'' +
                ", prdName='" + prdName + '\'' +
                ", tickNum=" + tickNum +
                ", mctname='" + mctname + '\'' +
                '}';
    }

    public void setMctname(String mctname) {
        this.mctname = mctname;
    }
}
