package com.yueserver.bean;

import java.util.Date;

public class Manage {

    private int mngno;
    private Date mngtime;
    private int mctno;
    private int brdno;

    public int getMngno() {
        return mngno;
    }

    public void setMngno(int mngno) {
        this.mngno = mngno;
    }

    public Date getMngtime() {
        return mngtime;
    }

    public void setMngtime(Date mngtime) {
        this.mngtime = mngtime;
    }

    public int getMctno() {
        return mctno;
    }

    public void setMctno(int mctno) {
        this.mctno = mctno;
    }

    public int getBrdno() {
        return brdno;
    }

    public void setBrdno(int brdno) {
        this.brdno = brdno;
    }

    @Override
    public String toString() {
        return "Manage{" +
                "mngno=" + mngno +
                ", mngtime=" + mngtime +
                ", mctno=" + mctno +
                ", brdno=" + brdno +
                '}';
    }
}
