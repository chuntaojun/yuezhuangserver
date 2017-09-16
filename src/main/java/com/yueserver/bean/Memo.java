package com.yueserver.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class Memo {

    private long memono;
    private Timestamp memotime;
    private Date memodeadline;
    private String memomain;
    private Date memoprdtime;
    private double memoprdprice;
    private Date memoprdbuildtime;
    private int memoprdholdtime;

    public Memo(){}

    public long getMemono() {
        return memono;
    }

    public void setMemono(long memono) {
        this.memono = memono;
    }

    public Timestamp getMemotime() {
        return memotime;
    }

    public void setMemotime(Timestamp memotime) {
        this.memotime = memotime;
    }

    public Date getMemodeadline() {
        return memodeadline;
    }

    public void setMemodeadline(Date memodeadline) {
        this.memodeadline = memodeadline;
    }

    public String getMemomain() {
        return memomain;
    }

    public void setMemomain(String memomain) {
        this.memomain = memomain;
    }

    public Date getMemoprdtime() {
        return memoprdtime;
    }

    public void setMemoprdtime(Date memoprdtime) {
        this.memoprdtime = memoprdtime;
    }

    public double getMemoprdprice() {
        return memoprdprice;
    }

    public void setMemoprdprice(double memoprdprice) {
        this.memoprdprice = memoprdprice;
    }

    public Date getMemoprdbuildtime() {
        return memoprdbuildtime;
    }

    public void setMemoprdbuildtime(Date memoprdbuildtime) {
        this.memoprdbuildtime = memoprdbuildtime;
    }

    public int getMemoprdholdtime() {
        return memoprdholdtime;
    }

    public void setMemoprdholdtime(int memoprdholdtime) {
        this.memoprdholdtime = memoprdholdtime;
    }
}
