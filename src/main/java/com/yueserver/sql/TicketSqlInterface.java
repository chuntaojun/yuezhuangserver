package com.yueserver.sql;

import com.yueserver.enity.nodao.MerchantTicket;

public interface TicketSqlInterface {

    boolean saveMerchantTicket(MerchantTicket ticket);
    boolean updateMerchantTicket(MerchantTicket ticket);
    boolean deleteMerchantTicket(MerchantTicket ticket);
    boolean VoucherTicket(MerchantTicket ticket);


}
