package com.yueserver.bean;

public class Administator {

    private int admno;
    private String admaccount;
    private String admpassword;
    private String admauthcode;

    public Administator(){}

    public int getAdmno() {
        return admno;
    }

    public void setAdmno(int admno) {
        this.admno = admno;
    }

    public String getAdmaccount() {
        return admaccount;
    }

    public void setAdmaccount(String admaccount) {
        this.admaccount = admaccount;
    }

    public String getAdmpassword() {
        return admpassword;
    }

    public void setAdmpassword(String admpassword) {
        this.admpassword = admpassword;
    }

    public String getAdmauthcode() {
        return admauthcode;
    }

    public void setAdmauthcode(String admauthcode) {
        this.admauthcode = admauthcode;
    }

    @Override
    public String toString() {
        return "Administator{" +
                "admno=" + admno +
                ", admaccount='" + admaccount + '\'' +
                ", admpassword='" + admpassword + '\'' +
                ", admauthcode='" + admauthcode + '\'' +
                '}';
    }
}
