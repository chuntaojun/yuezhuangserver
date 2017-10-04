package com.yueserver.database.impl;

import com.yueserver.database.dao.AdminMapper;
import com.yueserver.database.dao.LoginMapper;
import com.yueserver.database.dao.MerchantMapper;
import com.yueserver.enity.Administator;
import com.yueserver.enity.noenity.ForgotPassword;
import com.yueserver.enity.Merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("LoginSql")
public class LoginSql implements LoginMapper {

    @Autowired
    @Resource(name = "AdminSql")
    private AdminMapper adminDao;

    @Autowired
    @Resource(name = "MerchantSql")
    private MerchantMapper merchantDao;

    @Override
    public boolean getExistUser(String mctaccount) {
        if (merchantDao.MerchantLogin(mctaccount) == null)
            return true;
        return false;
    }

    @Override
    public Object getLoginObject(String mctaccount, String adminaccount) {
        Administator admin = this.adminDao.AdminLogin(adminaccount);
        Merchant merchant = this.merchantDao.MerchantLogin(mctaccount);
        if (admin != null) {
            return admin;
        }
        return merchant;
    }

    @Override
    public boolean updatePassword(ForgotPassword forgotPassword) {
        Merchant merchant = new Merchant();
        merchant.setMctaccount(forgotPassword.getUsername());
        merchant.setMctpassword(forgotPassword.getPassword());
        return this.merchantDao.updateMerchant(merchant);
    }

    @Override
    public boolean saveNewAccount(Merchant merchant) {
        return this.merchantDao.insertMerchant(merchant);
    }
}
