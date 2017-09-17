package com.yueserver.service;


import com.yueserver.adaper.MethodNourtFoundException;
import com.yueserver.enity.nodao.ForgotPassword;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

public interface LoginInterface {

    boolean TheMerchantExist(String username);
    boolean AddNewMerchant(String mctaccount, String password) throws MethodNourtFoundException;
    Object getLoginObject(String username) throws MethodNourtFoundException;
    JSONObject ChangePasswordIsWork(ForgotPassword forgotPassword, HttpSession session) throws ParseException;

}
