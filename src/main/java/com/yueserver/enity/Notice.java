package com.yueserver.enity;

public class Notice {

    private long ntcno;
    private String ncttitle;
    private String ntcmain;

    public Notice(){}

    public long getNtcno() {
        return ntcno;
    }

    public void setNtcno(long ntcno) {
        this.ntcno = ntcno;
    }

    public String getNcttitle() {
        return ncttitle;
    }

    public void setNcttitle(String ncttitle) {
        this.ncttitle = ncttitle;
    }

    public String getNtcmain() {
        return ntcmain;
    }

    public void setNtcmain(String ntcmain) {
        this.ntcmain = ntcmain;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "ntcno=" + ntcno +
                ", ncttitle='" + ncttitle + '\'' +
                ", ntcmain='" + ntcmain + '\'' +
                '}';
    }
}
