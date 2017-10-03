package com.yueserver.database.impl;

import com.yueserver.database.dao.TicketMapper;
import com.yueserver.enity.Ticket;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("TicketSql")
public class TicketSql implements TicketMapper {

    @Resource
    private TicketMapper ticketMapper;

    @Override
    public boolean saveMerchantTicket(Ticket ticket) {
        return this.ticketMapper.saveMerchantTicket(ticket);
    }

    @Override
    public boolean updateMerchantTicket(Ticket ticket) {
        return this.ticketMapper.updateMerchantTicket(ticket);
    }

    @Override
    public boolean deleteMerchantTicket(Ticket ticket) {
        return this.ticketMapper.deleteMerchantTicket(ticket);
    }

    @Override
    public boolean VoucherTicket(Ticket ticket) {
        return this.ticketMapper.VoucherTicket(ticket);
    }
}
