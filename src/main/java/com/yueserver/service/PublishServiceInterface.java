package com.yueserver.service;

import com.yueserver.enity.Notice;
import com.yueserver.enity.nodao.MerchantTicket;
import com.yueserver.enity.nodao.ResultBean;

public interface PublishServiceInterface {

    ResultBean<Boolean> SaveNotice(Notice notice);

}
