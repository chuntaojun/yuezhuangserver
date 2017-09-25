package com.yueserver.enity.nodao;

import java.util.Date;

public class MerchantTicket {

    private int tickNo;
    private String brdName;
    private String prdName;
    private int tickNum;
    private String mctname;
    private Date starttime;
    private Date deadline;

    public int getTickNo() {
        return tickNo;
    }

    public void setTickNo(int tickNo) {
        this.tickNo = tickNo;
    }

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

    public void setMctname(String mctname) {
        this.mctname = mctname;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "MerchantTicket{" +
                "brdName='" + brdName + '\'' +
                ", prdName='" + prdName + '\'' +
                ", tickNum=" + tickNum +
                ", mctname='" + mctname + '\'' +
                ", starttime=" + starttime +
                ", deadline=" + deadline +
                '}';
    }
}
