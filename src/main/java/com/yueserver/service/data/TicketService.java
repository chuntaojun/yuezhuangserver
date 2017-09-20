package com.yueserver.service.data;

import com.yueserver.enity.nodao.ResultBean;
import com.yueserver.service.TicketInterface;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("TicketService")
public class TicketService implements TicketInterface {

    /**
     * 添加优惠券信息
     * @return
     */
    @Override
    public ResultBean<Boolean> addTicket() {
        return null;
    }

    /**
     * 取消优惠券
     * @return
     */
    @Override
    public ResultBean<Boolean> cancleTicket() {
        return null;
    }

    /**
     * 剩余优惠券张数
     * @return
     */
    @Override
    public ResultBean<Map> getRemainTicket() {
        return null;
    }

    /**
     * 线程安全设定，避免出现抢券造成券的发放与实际不符合
     * 并返回抢券是否成功
     * @return
     */
    public static synchronized ResultBean<Boolean> VoucherTicket() {
        return null;
    }
}
