package com.yueserver.service;

import com.yueserver.enity.nodao.MerchantTicket;
import com.yueserver.enity.nodao.ResultBean;

import java.util.Map;

public interface TicketInterface {

    ResultBean<Boolean> addTicket(MerchantTicket ticket);
    ResultBean<Boolean> cancleTicket(MerchantTicket ticket);
    ResultBean<Map> getRemainTicket(MerchantTicket ticket);
    ResultBean<Boolean> VoucherTicket(MerchantTicket ticket);

}
