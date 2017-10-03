package com.yueserver.database.impl;

import com.yueserver.database.dao.NoticeMapper;
import com.yueserver.enity.Notice;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Secured("ROLE_ADMIN")
@Service("NoticeSql")
public class NoticeSql implements NoticeMapper{

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public boolean SaveNotice(Notice notice) {
        return this.noticeMapper.SaveNotice(notice);
    }
}
