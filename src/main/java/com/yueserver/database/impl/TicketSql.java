package com.yueserver.database.impl;

import com.yueserver.enity.MerchantTicket;
import com.yueserver.database.TicketSqlInterface;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("TicketSql")
public class TicketSql implements TicketSqlInterface {

    @Autowired
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;


    @Override
    public boolean saveMerchantTicket(MerchantTicket ticket) {
        return false;
    }

    @Override
    public boolean updateMerchantTicket(MerchantTicket ticket) {
        return false;
    }

    @Override
    public boolean deleteMerchantTicket(MerchantTicket ticket) {
        return false;
    }

    @Override
    public boolean VoucherTicket(MerchantTicket ticket) {
        return false;
    }
}
