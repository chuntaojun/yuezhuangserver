package com.yueserver.service;

import com.yueserver.enity.Notice;
import com.yueserver.enity.noenity.ResultBean;

public interface PublishServiceInterface {

    ResultBean<Boolean> SaveNotice(Notice notice);

}
