package com.yueserver.service;

import javax.servlet.http.HttpSession;

public interface EmailInterface {

    void SendVerificationCodeEmail(String address, boolean cansend, HttpSession session);
    void SendRegistere(String address);
    void SendMerchantCanLogin(String address);
    String setVerificationCode();
    void VerificationCodeExpired(HttpSession session);
}
