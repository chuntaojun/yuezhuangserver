package com.yueserver.service;

import com.yueserver.enity.nodao.ResultBean;

import javax.servlet.http.HttpSession;

public interface EmailInterface {

    void SendVerificationCodeEmail(String address, boolean cansend, HttpSession session);
    void SendRegistere(String address);
    void SendMerchantCanLogin(String address);
    void VerificationCodeExpired(HttpSession session);

    ResultBean<Boolean> SendIssueFeedBack(String address, String context);

    ResultBean<String> setVerificationCode();
}
