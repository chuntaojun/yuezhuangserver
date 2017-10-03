package com.yueserver.database.impl;

import com.sun.xml.internal.ws.handler.HandlerException;
import com.yueserver.enity.Notice;
import com.yueserver.database.NoticeSqlInterface;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Secured("ROLE_ADMIN")
@Service("NoticeSql")
public class NoticeSql implements NoticeSqlInterface {

    @Autowired
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;


    @Override
    public boolean SaveNotice(Notice notice) {
        return false;
    }
}
