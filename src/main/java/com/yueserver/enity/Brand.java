package com.yueserver.enity;


import java.util.Set;

public class Brand {

    private int brdno;
    private String brdname;
    private String brdintro;
    private String brdlogo;
    private int mctno;

    public Brand() {}

    public int getBrdno() {
        return brdno;
    }

    public void setBrdno(int brdno) {
        this.brdno = brdno;
    }

    public String getBrdname() {
        return brdname;
    }

    public void setBrdname(String brdname) {
        this.brdname = brdname;
    }

    public String getBrdintro() {
        return brdintro;
    }

    public void setBrdintro(String brdintro) {
        this.brdintro = brdintro;
    }

    public String getBrdlogo() {
        return brdlogo;
    }

    public void setBrdlogo(String brdlogo) {
        this.brdlogo = brdlogo;
    }

    public int getMctno() {
        return mctno;
    }

    public void setMctno(int mctno) {
        this.mctno = mctno;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brdno=" + brdno +
                ", brdname='" + brdname + '\'' +
                ", brdintro='" + brdintro + '\'' +
                ", brdlogo='" + brdlogo + '\'' +
                ", mctno=" + mctno +
                '}';
    }
}
