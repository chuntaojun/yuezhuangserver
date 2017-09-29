package com.yueserver.database.impl;

import com.yueserver.database.PrdVidSqlInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("PrdVidSql")
public class PrdVidSql implements PrdVidSqlInterface {

    @Autowired(required = false)
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public boolean saveBatchPrdVid(Map<String, Object> prdvidMap) {
        return false;
    }

    @Override
    public boolean deleBatchPrdVid(Map<String, Object> prdvidMap) {
        return false;
    }
}
