package com.yueserver.service;

import com.yueserver.enity.Ticket;
import com.yueserver.enity.noenity.ResultBean;

import java.util.Map;

public interface TicketInterface {

    ResultBean<Boolean> addTicket(Ticket ticket);
    ResultBean<Boolean> cancleTicket(Ticket ticket);
    ResultBean<Map> getRemainTicket(Ticket ticket);
    ResultBean<Boolean> VoucherTicket(Ticket ticket);

}
