package com.yueserver.database.dao;

import com.yueserver.enity.Ticket;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketMapper {

    boolean saveMerchantTicket(@Param("Ticket") Ticket ticket);
    boolean updateMerchantTicket(Ticket ticket);
    boolean deleteMerchantTicket(Ticket ticket);
    boolean VoucherTicket(Ticket ticket);


}
