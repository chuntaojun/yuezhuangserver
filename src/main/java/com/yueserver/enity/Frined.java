package com.yueserver.bean;

import java.sql.Date;

public class Frined {

    private int frdno;
    private Date frdtime;

    public Frined(){}

    public int getFrdno() {
        return frdno;
    }

    public void setFrdno(int frdno) {
        this.frdno = frdno;
    }

    public Date getFrdtime() {
        return frdtime;
    }

    public void setFrdtime(Date frdtime) {
        this.frdtime = frdtime;
    }
}
