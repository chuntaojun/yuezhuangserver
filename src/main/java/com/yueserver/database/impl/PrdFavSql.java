package com.yueserver.database.impl;

import com.yueserver.enity.PrdFav;
import com.yueserver.database.PrdFavSqlInterface;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PrdFavSql")
public class PrdFavSql implements PrdFavSqlInterface {

    @Autowired
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;


    @Override
    public boolean savePrdFav(PrdFav prdFav) {
        return false;
    }

    @Override
    public List queryPrdFavData() {
        return null;
    }
}
