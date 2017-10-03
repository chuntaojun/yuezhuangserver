package com.yueserver.enity;

import java.sql.Timestamp;

public class Ticket {

    private int tctno;
    private double tctdiscount;
    private Timestamp tcttime;
    private Timestamp tctdeadline;
    private int tctsum;
    private int tcttypeno;
    private int brdno;

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

    public int getTcttypeno() {
        return tcttypeno;
    }

    public void setTcttypeno(int tcttypeno) {
        this.tcttypeno = tcttypeno;
    }

    public int getBrdno() {
        return brdno;
    }

    public void setBrdno(int brdno) {
        this.brdno = brdno;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "tctno=" + tctno +
                ", tctdiscount=" + tctdiscount +
                ", tcttime=" + tcttime +
                ", tctdeadline=" + tctdeadline +
                ", tctsum=" + tctsum +
                ", tcttypeno=" + tcttypeno +
                '}';
    }
}
