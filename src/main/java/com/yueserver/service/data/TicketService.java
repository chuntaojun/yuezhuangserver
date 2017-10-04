package com.yueserver.service.data;

import com.yueserver.enity.Ticket;
import com.yueserver.enity.noenity.ResultBean;
import com.yueserver.service.TicketInterface;
import com.yueserver.database.dao.TicketMapper;

import org.springframework.core.task.TaskExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("TicketService")
public class TicketService implements TicketInterface {

    @Autowired
    @Resource(name = "TicketSql")
    private TicketMapper ticketSqlInterface;

    @Autowired
    @Resource(name = "taskExecutor")
    private TaskExecutor executor;

    /**
     * 添加优惠券信息
     * @return
     */
    @Override
    public ResultBean<Boolean> addTicket(Ticket ticket) {
        return new ResultBean<>(ticketSqlInterface.saveMerchantTicket(ticket));
    }

    /**
     * 取消优惠券
     * @return
     */
    @Override
    public ResultBean<Boolean> cancleTicket(Ticket ticket) {
        return null;
    }

    /**
     * 剩余优惠券张数
     * @return
     */
    @Override
    public ResultBean<Map> getRemainTicket(Ticket ticket) {
        return null;
    }

    /**
     * 线程安全设定，避免出现抢券造成券的发放与实际不符合
     * 并返回抢券是否成功
     * @return
     */
    @Override
    public ResultBean<Boolean> VoucherTicket(Ticket ticket) {
        executor.execute(() -> {
            synchronized (ticketSqlInterface) {
                ticket.setTctsum(ticket.getTctsum() - 1);
                ticketSqlInterface.VoucherTicket(ticket);
            }
        });
        return new ResultBean<>(false);
    }
}
