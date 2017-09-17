package com.yueserver.enity;

import java.sql.Date;

public class BrdFav {

    private long brdfavno;
    private Date brdfavtime;

    public BrdFav(){}

    public long getBrdfavno() {
        return brdfavno;
    }

    public void setBrdfavno(long brdfavno) {
        this.brdfavno = brdfavno;
    }

    public Date getBrdfavtime() {
        return brdfavtime;
    }

    public void setBrdfavtime(Date brdfavtime) {
        this.brdfavtime = brdfavtime;
    }
}
