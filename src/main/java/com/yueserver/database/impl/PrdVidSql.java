package com.yueserver.database.impl;

import com.yueserver.database.PrdVidSqlInterface;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("PrdVidSql")
public class PrdVidSql implements PrdVidSqlInterface {

    @Autowired
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;


    @Override
    public boolean saveBatchPrdVid(Map<String, Object> prdvidMap) {
        return false;
    }

    @Override
    public boolean deleBatchPrdVid(Map<String, Object> prdvidMap) {
        return false;
    }
}
