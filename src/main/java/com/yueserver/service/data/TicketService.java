package com.yueserver.service.data;

import com.yueserver.database.redisutil.RedisCacheInterface;
import com.yueserver.enity.Ticket;
import com.yueserver.enity.noenity.ResultBean;
import com.yueserver.service.TicketInterface;
import com.yueserver.database.dao.TicketMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import static com.yueserver.controller.LoginController.getPrincipal;

@Service("TicketService")
public class TicketService implements TicketInterface {

    @Autowired
    @Resource(name = "TicketSql")
    private TicketMapper ticketSqlInterface;

    @Autowired
    @Resource(name = "RedisCache")
    private RedisCacheInterface redisCacheInterface;

    /**
     * 添加优惠券信息
     * 同时将优惠券信息发布到redis数据库中，
     * @param ticket
     * @return
     */
    @Override
    public ResultBean<Boolean> addTicket(Ticket ticket) {
        boolean redis_commit = redisCacheInterface.NumberCache(new ResultBean<>(ticket.getTctsum()),
                ticket.getBrdno() + "&" + getPrincipal().getMctno()).getData();
        boolean sql_commit = ticketSqlInterface.saveMerchantTicket(ticket);
        return new ResultBean<>(redis_commit && sql_commit);
    }

    /**
     * 取消优惠券
     * @return
     */
    @Override
    public ResultBean<Boolean> cancleTicket(Ticket ticket) {
        boolean redis_commit = redisCacheInterface.DeleteValueCache(ticket.getBrdno() + "&" + getPrincipal().getMctno()).getData();
        boolean sql_commit = ticketSqlInterface.deleteMerchantTicket(ticket);
        return new ResultBean<>(redis_commit && sql_commit);
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
     * 若成功，则更新redis缓存中的对应数据，并获取更新后的最新值，进行余量判断
     * @return
     */
    @Override
    public ResultBean<Boolean> VoucherTicket(Ticket ticket) {
        //重写，不直接与数据库进行事务交互
        return null;
    }

    @Override
    public ResultBean<Boolean> VoucharTimeIsDead() {
        return null;
    }
}
