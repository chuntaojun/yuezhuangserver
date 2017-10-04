package com.yueserver.enity;

public class PrdPic {

    private int prdpicno;
    private String prdpicurl;
    private int prdno;

    public PrdPic(){}

    public int getPrdpicno() {
        return prdpicno;
    }

    public void setPrdpicno(int prdpicno) {
        this.prdpicno = prdpicno;
    }

    public String getPrdpicurl() {
        return prdpicurl;
    }

    public void setPrdpicurl(String prdpicurl) {
        this.prdpicurl = prdpicurl;
    }

    public int getPrdno() {
        return prdno;
    }

    public void setPrdno(int prdno) {
        this.prdno = prdno;
    }

    @Override
    public String toString() {
        return "PrdPic{" +
                "prdpicno=" + prdpicno +
                ", prdpicurl='" + prdpicurl + '\'' +
                ", prdno=" + prdno +
                '}';
    }
}
