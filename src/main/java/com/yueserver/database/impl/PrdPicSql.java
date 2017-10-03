package com.yueserver.database.impl;

import com.yueserver.database.PrdPicSqlInterface;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("PrdPicSql")
public class PrdPicSql implements PrdPicSqlInterface {

    @Autowired
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;


    @Override
    public boolean saveBatchPrdPic(Map<String, Object> prdpicMap) {
        return false;
    }

    @Override
    public boolean deleBatchPrdPic(Map<String, Object> prdpicMap) {
        return false;
    }
}
