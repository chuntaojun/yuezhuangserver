package com.yueserver.service.data;

import com.yueserver.enity.Notice;
import com.yueserver.service.PublishServiceInterface;
import com.yueserver.sql.NoticeSqlInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Secured("ROLE_ADMIN")
@Service("PublishService")
public class PublishService implements PublishServiceInterface {

    @Autowired
    @Resource(name = "NoticeSql")
    private NoticeSqlInterface noticeSqlInterface;

    @Override
    public boolean SaveNotice(Notice notice) {
        return noticeSqlInterface.SaveNotice(notice);
    }
}
