package com.yueserver.enity;

public class PrdLike {

    private int prdlikeno;
    private int prdno;
    private String usrname;
    private double likescore;

    public int getPrdlikeno() {
        return prdlikeno;
    }

    public void setPrdlikeno(int prdlikeno) {
        this.prdlikeno = prdlikeno;
    }

    public int getPrdno() {
        return prdno;
    }

    public void setPrdno(int prdno) {
        this.prdno = prdno;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public double getLikescore() {
        return likescore;
    }

    public void setLikescore(double likescore) {
        this.likescore = likescore;
    }

    @Override
    public String toString() {
        return "PrdLike{" +
                "prdlikeno=" + prdlikeno +
                ", prdno=" + prdno +
                ", usrname='" + usrname + '\'' +
                ", likescore=" + likescore +
                '}';
    }
}
