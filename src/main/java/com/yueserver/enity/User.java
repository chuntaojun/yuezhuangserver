package com.yueserver.enity;

import java.sql.Date;

public class User {

    private int userno;
    private int userphone;
    private String usrname;
    private String usrpassword;
    private int usersex;
    private String userimage;
    private Date userbirthday;
    private int userage;
    private Date usertime;
    private String userqq;
    private String userwechat;
    private int userfriendway;
    private String userintro;
    private int usrstatus;

    public User(){}

    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public int getUserphone() {
        return userphone;
    }

    public void setUserphone(int userphone) {
        this.userphone = userphone;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getUsrpassword() {
        return usrpassword;
    }

    public void setUsrpassword(String usrpassword) {
        this.usrpassword = usrpassword;
    }

    public int getUsersex() {
        return usersex;
    }

    public void setUsersex(int usersex) {
        this.usersex = usersex;
    }

    public String getUserimage() {
        return userimage;
    }

    public void setUserimage(String userimage) {
        this.userimage = userimage;
    }

    public Date getUserbirthday() {
        return userbirthday;
    }

    public void setUserbirthday(Date userbirthday) {
        this.userbirthday = userbirthday;
    }

    public int getUserage() {
        return userage;
    }

    public void setUserage(int userage) {
        this.userage = userage;
    }

    public Date getUsertime() {
        return usertime;
    }

    public void setUsertime(Date usertime) {
        this.usertime = usertime;
    }

    public String getUserqq() {
        return userqq;
    }

    public void setUserqq(String userqq) {
        this.userqq = userqq;
    }

    public String getUserwechat() {
        return userwechat;
    }

    public void setUserwechat(String userwechat) {
        this.userwechat = userwechat;
    }

    public int getUserfriendway() {
        return userfriendway;
    }

    public void setUserfriendway(int userfriendway) {
        this.userfriendway = userfriendway;
    }

    public String getUserintro() {
        return userintro;
    }

    public void setUserintro(String userintro) {
        this.userintro = userintro;
    }

    public int getUsrstatus() {
        return usrstatus;
    }

    public void setUsrstatus(int usrstatus) {
        this.usrstatus = usrstatus;
    }
}
