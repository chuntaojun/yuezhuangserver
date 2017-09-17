package com.yueserver.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class TctGet {

    private int tctgetno;
    private Date tctgettime;
    private int tctgetway;

    public TctGet(){}

    public int getTctgetno() {
        return tctgetno;
    }

    public void setTctgetno(int tctgetno) {
        this.tctgetno = tctgetno;
    }

    public Date getTctgettime() {
        return tctgettime;
    }

    public void setTctgettime(Date tctgettime) {
        this.tctgettime = tctgettime;
    }

    public int getTctgetway() {
        return tctgetway;
    }

    public void setTctgetway(int tctgetway) {
        this.tctgetway = tctgetway;
    }
}
