package com.yueserver.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class PrdFav {

    private long prdfavno;
    private Date prdfavtime;

    public PrdFav(){}

    public long getPrdfavno() {
        return prdfavno;
    }

    public void setPrdfavno(long prdfavno) {
        this.prdfavno = prdfavno;
    }

    public Date getPrdfavtime() {
        return prdfavtime;
    }

    public void setPrdfavtime(Date prdfavtime) {
        this.prdfavtime = prdfavtime;
    }
}
