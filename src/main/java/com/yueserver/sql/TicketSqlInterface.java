package com.yueserver.sql;

import com.yueserver.enity.nodao.MerchantTicket;

public interface TicketSqlInterface {

    boolean SaveMerchantTicket(MerchantTicket ticket);
    boolean updateMerchantTicket(MerchantTicket ticket);
    boolean deleteMerchantTicket(MerchantTicket ticket);

}
