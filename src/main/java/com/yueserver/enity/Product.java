package com.yueserver.enity;

import java.util.List;

/**
 * Created by liaochuntao on 17-7-12.
 */

public class Product {

    private int prdno;
    private String prdname;
    private String prdcode;
    private String prdintro;
    private double prdprice;
    private double prdcapacity;
    private int prdtypeno;
    private int brdno;
    private List<PrdPic> prdPics;

    public Product(){}

    public int getPrdno() {
        return prdno;
    }

    public void setPrdno(int prdno) {
        this.prdno = prdno;
    }

    public String getPrdname() {
        return prdname;
    }

    public void setPrdname(String prdname) {
        this.prdname = prdname;
    }

    public String getPrdcode() {
        return prdcode;
    }

    public void setPrdcode(String prdcode) {
        this.prdcode = prdcode;
    }

    public String getPrdintro() {
        return prdintro;
    }

    public void setPrdintro(String prdintro) {
        this.prdintro = prdintro;
    }

    public double getPrdprice() {
        return prdprice;
    }

    public void setPrdprice(double prdprice) {
        this.prdprice = prdprice;
    }

    public double getPrdcapacity() {
        return prdcapacity;
    }

    public void setPrdcapacity(double prdcapacity) {
        this.prdcapacity = prdcapacity;
    }

    public int getPrdtypeno() {
        return prdtypeno;
    }

    public void setPrdtypeno(int prdtypeno) {
        this.prdtypeno = prdtypeno;
    }

    public int getBrdno() {
        return brdno;
    }

    public void setBrdno(int brdno) {
        this.brdno = brdno;
    }

    public List<PrdPic> getPrdPics() {
        return prdPics;
    }

    public void setPrdPics(List<PrdPic> prdPics) {
        this.prdPics = prdPics;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prdno=" + prdno +
                ", prdname='" + prdname + '\'' +
                ", prdcode='" + prdcode + '\'' +
                ", prdintro='" + prdintro + '\'' +
                ", prdprice=" + prdprice +
                ", prdcapacity=" + prdcapacity +
                ", prdtypeno=" + prdtypeno +
                ", brdno=" + brdno +
                ", prdPics=" + prdPics +
                '}';
    }
}
