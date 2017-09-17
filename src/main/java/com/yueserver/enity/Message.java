package com.yueserver.enity;

import java.sql.Time;

public class Message {

    private int msagno;
    private int msgtype;
    private String msgmain;
    private Time msgtime;
    private int msgstate;

    public Message(){
    }

    public int getMsagno() {
        return msagno;
    }

    public void setMsagno(int msagno) {
        this.msagno = msagno;
    }

    public int getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(int msgtype) {
        this.msgtype = msgtype;
    }

    public String getMsgmain() {
        return msgmain;
    }

    public void setMsgmain(String msgmain) {
        this.msgmain = msgmain;
    }

    public Time getMsgtime() {
        return msgtime;
    }

    public void setMsgtime(Time msgtime) {
        this.msgtime = msgtime;
    }

    public int getMsgstate() {
        return msgstate;
    }

    public void setMsgstate(int msgstate) {
        this.msgstate = msgstate;
    }
}
