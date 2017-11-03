package com.yueserver.database.dao;

import com.yueserver.enity.Merchant;
import com.yueserver.enity.noenity.ForgotPassword;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {

    boolean getExistUser(String mctaccount);
    Object getLoginObject(String usrname, String advice);
    boolean updatePassword(ForgotPassword forgotPassword);
    boolean saveNewAccount(Merchant merchant);

}
