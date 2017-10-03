package com.yueserver.database.dao;

import com.yueserver.enity.Merchant;
import com.yueserver.enity.nodao.ForgotPassword;
import com.yueserver.enity.nodao.Login;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginMapper {

    boolean getExistUser(String mctaccount);
    Object getLoginObject(String mctaccount, String adminaccount);
    boolean updatePassword(ForgotPassword forgotPassword);
    boolean saveNewAccount(Merchant merchant);

}
