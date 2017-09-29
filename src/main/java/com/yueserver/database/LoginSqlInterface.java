package com.yueserver.database;

import com.yueserver.enity.Merchant;
import com.yueserver.enity.nodao.ForgotPassword;

import java.util.List;

public interface LoginSqlInterface {

    boolean getExistUser(String mctaccount);
    List getLoginObject(String mctaccount, String adminaccount);
    boolean updatePassword(ForgotPassword forgotPassword);
    boolean saveNewAccount(Merchant merchant);

}
