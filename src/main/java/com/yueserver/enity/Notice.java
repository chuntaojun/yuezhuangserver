package com.yueserver.enity;

public class Notice {

    private long ntcno;
    private String ntctitle;
    private String ntcmain;

    public Notice(){}

    public long getNtcno() {
        return ntcno;
    }

    public void setNtcno(long ntcno) {
        this.ntcno = ntcno;
    }

    public String getNtctitle() {
        return ntctitle;
    }

    public void setNtctitle(String ntctitle) {
        this.ntctitle = ntctitle;
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
                ", ncttitle='" + ntctitle + '\'' +
                ", ntcmain='" + ntcmain + '\'' +
                '}';
    }
}
