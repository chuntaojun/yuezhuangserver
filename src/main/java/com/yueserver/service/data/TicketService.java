package com.yueserver.service.data;

import com.yueserver.enity.nodao.MerchantTicket;
import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.TicketInterface;
import com.yueserver.sql.TicketSqlInterface;
import com.yueserver.sql.impl.TicketSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("TicketService")
public class TicketService implements TicketInterface {

    @Autowired
    @Resource(name = "TicketSql")
    private TicketSqlInterface ticketSqlInterface;

    /**
     * 添加优惠券信息
     * @return
     */
    @Override
    public ResultBean<Boolean> addTicket(MerchantTicket ticket) {
        return new ResultBean<>(ticketSqlInterface.SaveMerchantTicket(ticket));
    }

    /**
     * 取消优惠券
     * @return
     */
    @Override
    public ResultBean<Boolean> cancleTicket(MerchantTicket ticket) {
        return null;
    }

    /**
     * 剩余优惠券张数
     * @return
     */
    @Override
    public ResultBean<Map> getRemainTicket(MerchantTicket ticket) {
        return null;
    }

    /**
     * 线程安全设定，避免出现抢券造成券的发放与实际不符合
     * 并返回抢券是否成功
     * @return
     */
    public static synchronized ResultBean<Boolean> VoucherTicket(MerchantTicket ticket) {
        ticket.setTickNum(ticket.getTickNum() - 1);
        boolean b = new TicketSql().updateMerchantTicket(ticket);
        return new ResultBean<>(b);
    }
}
