package com.yueserver.service.impl;

import com.yueserver.service.EmailInterface;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.*;

@EnableAsync
@Service("emailservice")
public class EmailToMerchant implements EmailInterface {

    private void setEmail(String subject, String context, String address) {
        try {
            Properties properties = new Properties();
            properties.setProperty("mail.host", "smtp.qq.com");
            properties.setProperty("mail.transport.protocol", "smtp");
            properties.setProperty("mail.smtp.auth", "true");
            properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.setProperty("mail.smtp.port", "465");
            properties.setProperty("mail.smtp.socketFactory.port", "465");
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("1069284099@qq.com", "cevouotdaqqibfhd");
                }
            });
            //开始发送邮件
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("1069284099@qq.com"));
            //设置收件人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
            //设置邮件主题
            message.setSubject(new Date() + "-" + subject);
            //设置邮件正文与编码
            message.setContent(context, "text/html;charset=UTF-8");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程异步执行发送邮件操作
     * 发送邮件验证码
     * @param address
     * @param cansend
     * @param httpsession
     */
    @Async
    @Override
    public void SendVerificationCodeEmail(String address, boolean cansend, HttpSession httpsession) {
        String authcode = setVerificationCode();
        httpsession.setAttribute("authcode", authcode);
        String context = "该验证码的有效时间为5分钟，过期验证码将失效。\n验证码：" + authcode;
        if (cansend) {
            setEmail("验证码", context, address);
            System.out.println("测试是否是异步执行-2");
        }
    }

    /**
     * 用户注册完后进行发送邮件进行通知
     * @param address
     * @throws MessagingException
     */
    @Async
    @Override
    public void SendRegistere(String address) {
        String context = "当前账户待审核,请注意查收邮件,我们将通过邮件通知您审核进度";
        setEmail("账户审核", context, address);
        System.out.println(new Date());
    }

    /**
     * 管理员审核账户成功后发送邮件通知商家 (异步执行)
     * @param address
     * @throws MessagingException
     */
    @Async
    @Override
    public void SendMerchantCanLogin(String address) {
        String context = "您现在已近可以登录了";
        setEmail("审核成功", context, address);
    }

    /**
     * 生成8位数字字母混合的验证码
     * @return
     */
    @Override
    public String setVerificationCode() {
        String authcode = "";
        Random random = new Random();
        for(int i = 0; i < 8; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if( "char".equalsIgnoreCase(charOrNum) ) {
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                authcode += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                authcode += String.valueOf(random.nextInt(10));
            }
        }
        return authcode;
    }

    /**
     * 验证码时效问题
     * @param session
     */
    @Override
    public void VerificationCodeExpired(HttpSession session) {
        try {
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (session.getAttribute("authcode") != null)
                        session.removeAttribute("authcode");
                }
            }, 5 * 60 * 1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
