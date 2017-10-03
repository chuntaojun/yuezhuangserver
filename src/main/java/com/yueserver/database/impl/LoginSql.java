package com.yueserver.database.impl;

import com.yueserver.enity.nodao.ForgotPassword;
import com.yueserver.database.LoginSqlInterface;
import com.yueserver.enity.Merchant;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("LoginSql")
public class LoginSql implements LoginSqlInterface {

    @Autowired
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public boolean getExistUser(String mctaccount) {
        return false;
    }

    @Override
    public List getLoginObject(String mctaccount, String adminaccount) {
        return null;
    }

    @Override
    public boolean updatePassword(ForgotPassword forgotPassword) {
        return false;
    }

    @Override
    public boolean saveNewAccount(Merchant merchant) {
        return false;
    }
}
