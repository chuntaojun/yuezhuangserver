package com.yueserver.database.impl;

import com.yueserver.database.dao.AdminMapper;
import com.yueserver.enity.Administator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("AdminSql")
public class AdminSql implements AdminMapper {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Administator AdminLogin(String account) {
        return this.adminMapper.AdminLogin(account);
    }
}
