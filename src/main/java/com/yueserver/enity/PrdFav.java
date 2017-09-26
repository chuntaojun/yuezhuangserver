package com.yueserver.enity;

import java.util.Date;

public class PrdFav {

    private int prdfavno;
    private Date prdfavtime;
    private double prdlike;
    private String usrname;
    private int prdno;

    public PrdFav(){}

    public int getPrdfavno() {
        return prdfavno;
    }

    public void setPrdfavno(int prdfavno) {
        this.prdfavno = prdfavno;
    }

    public Date getPrdfavtime() {
        return prdfavtime;
    }

    public void setPrdfavtime(Date prdfavtime) {
        this.prdfavtime = prdfavtime;
    }

    public double getPrdlike() {
        return prdlike;
    }

    public void setPrdlike(double prdlike) {
        this.prdlike = prdlike;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public int getPrdno() {
        return prdno;
    }

    public void setPrdno(int prdno) {
        this.prdno = prdno;
    }

    @Override
    public String toString() {
        return "PrdFav{" +
                "prdfavno=" + prdfavno +
                ", prdfavtime=" + prdfavtime +
                ", prdlike=" + prdlike +
                ", usrname='" + usrname + '\'' +
                ", prdno=" + prdno +
                '}';
    }
}
