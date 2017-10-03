package com.yueserver.database.impl;

import com.yueserver.enity.User;
import com.yueserver.database.UserSqlInterface;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UserSql")
public class UserSql implements UserSqlInterface {

    @Autowired
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;


    @Override
    public List queryUserInfo() {
        return null;
    }

    @Override
    public boolean updateSingleUser(User user) {
        return false;
    }
}
