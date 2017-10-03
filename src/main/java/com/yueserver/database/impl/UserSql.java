package com.yueserver.database.impl;

import com.yueserver.database.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UserSql")
public class UserSql implements UserMapper {

    @Resource
    private UserMapper userMapper;

    @Override
    public List queryUserInfo() {
        return this.userMapper.queryUserInfo();
    }

    @Override
    public boolean updateUserStatus(Integer status, Integer usrNo) {
        return this.userMapper.updateUserStatus(status, usrNo);
    }
}
