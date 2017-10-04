package com.yueserver.service.data;

import com.yueserver.enity.Notice;
import com.yueserver.enity.noenity.ResultBean;
import com.yueserver.service.PublishServiceInterface;
import com.yueserver.database.dao.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Secured({"ROLE_ADMIN", "ROLE_USER"})
@Service("PublishService")
public class PublishService implements PublishServiceInterface {

    @Autowired
    @Resource(name = "NoticeSql")
    private NoticeMapper noticeSqlInterface;

    @Override
    public ResultBean<Boolean> SaveNotice(Notice notice) {
        return new ResultBean<>(noticeSqlInterface.SaveNotice(notice));
    }

}
