package com.yueserver.service;

import com.yueserver.enity.nodao.ResultBean;

import java.util.Map;

public interface TicketInterface {

    ResultBean<Boolean> addTicket();
    ResultBean<Boolean> cancleTicket();
    ResultBean<Map> getRemainTicket();

}
