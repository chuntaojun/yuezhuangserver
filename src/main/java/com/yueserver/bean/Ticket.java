package com.yueserver.bean;

import java.sql.Timestamp;

public class Ticket {

    private int tctno;
    private double tctdiscount;
    private Timestamp tcttime;
    private Timestamp tctdeadline;
    private int tctsum;

    public Ticket(){}

    public int getTctno() {
        return tctno;
    }

    public void setTctno(int tctno) {
        this.tctno = tctno;
    }

    public double getTctdiscount() {
        return tctdiscount;
    }

    public void setTctdiscount(double tctdiscount) {
        this.tctdiscount = tctdiscount;
    }

    public Timestamp getTcttime() {
        return tcttime;
    }

    public void setTcttime(Timestamp tcttime) {
        this.tcttime = tcttime;
    }

    public Timestamp getTctdeadline() {
        return tctdeadline;
    }

    public void setTctdeadline(Timestamp tctdeadline) {
        this.tctdeadline = tctdeadline;
    }

    public int getTctsum() {
        return tctsum;
    }

    public void setTctsum(int tctsum) {
        this.tctsum = tctsum;
    }
}
