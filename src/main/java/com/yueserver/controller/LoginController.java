package com.yueserver.controller;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.yueserver.adaper.MethodNourtFoundException;
import com.yueserver.bean.nodao.ForgotPassword;
import com.yueserver.bean.nodao.Login;
import com.yueserver.bean.nodao.ResigterLogin;
import com.yueserver.service.EmailInterface;
import com.yueserver.service.LoginInterface;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by liaochuntao on 17-7-18.
 * 与登录注册以及登录验证找回密码等相关的controller
 */

@Controller
public class LoginController {

    @Autowired
    @Resource(name = "emailservice")
    private EmailInterface emailinterface;

    @Autowired
    @Resource(name = "LoginProcess")
    private LoginInterface loginInterface;

    /**
     * 用户注册，默认均为商家用户
     * @param resigterLogin
     * @param model
     * @return
     */
    @RequestMapping(value = "/registere", method = RequestMethod.POST)
    public String LoginRegistere(@ModelAttribute ResigterLogin resigterLogin, Model model) throws MethodNourtFoundException {
        boolean isOK =loginInterface.AddNewMerchant(resigterLogin.getMctaccount(), resigterLogin.getPassword());
        if (!isOK){
            model.addAttribute("errors", "用户已存在，请重新输入用户名");
            return "/registered";
        }
        model.addAttribute("username", resigterLogin.getMctaccount());
        emailinterface.SendRegistere(resigterLogin.getEmail());
        System.out.println("测试异步执行情况-1");
        /*
            返回message页面，告知注册商户待管理员审核通过即可登录，并通过邮箱进行告知商户
            message页面限定时间进行跳转至login.jsp页面
         */
        return "redirect:login.jsp?register=true";
    }

    /**
     * 用户登录校验
     * @param session
     * @return
     */
    @RequestMapping(value = "/login_check", method = RequestMethod.POST)
    public String LoginCheck(HttpSession session) {
        if (getPrincipal().getRole(getPrincipal().getAuthorities()).contains("ROLE_ADMIN")) {
            session.setAttribute("function_2", "用户管理");
            session.setAttribute("usertype", "管理员");
            session.setAttribute("username", getPrincipal().getUsername());
            return "redirect:/admin/show";
        }
        else {
            session.setAttribute("function_2", "数据报表");
            session.setAttribute("usertype", "商家");
            session.setAttribute("username", getPrincipal().getUsername());
            return "redirect:/yue/report/" + getPrincipal().getUsername();
        }
    }

    /**
     * 用户登出选项
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/loginout")
    public String LoginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null)
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        System.out.println("logout success");
        return "redirect:login.jsp?logout";
    }

    /**
     * (参数传递需要forward标签)
     * 用户登录失败信息处理
     * @param modelAndView
     * @param request
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/login_false")
    public ModelAndView LoginFalse(ModelAndView modelAndView, HttpServletRequest request)
            throws ServletException, IOException {
        modelAndView.addObject("username", request.getParameter("username"));
        modelAndView.setViewName("forward:/login.jsp?error=");
        return modelAndView;
    }

    /**
     * 用户单点登录信息显示
     * @param modelAndView
     * @param request
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/loginSingle")
    public ModelAndView LoginSingle(ModelAndView modelAndView, HttpServletRequest request)
            throws ServletException, IOException {
        modelAndView.addObject("errors", "你已在其他地方登录，请确认是您本人登录或修改密码");
        modelAndView.addObject("username", request.getParameter("username"));
        modelAndView.setViewName("redirect:/login.jsp?error=");
        return modelAndView;
    }

    /**
     * 用户更改密码所需信息表单处理
     * @param session
     * @param modelAndView
     * @param forgotPassword
     * @return
     * @throws MessagingException
     * @throws InterruptedException
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public ModelAndView ForgotPassword(HttpSession session, ModelAndView modelAndView, @ModelAttribute ForgotPassword forgotPassword)
            throws InterruptedException, IOException, ServletException, ParseException {
        JSONObject resultJson = loginInterface.ChangePasswordIsWork(forgotPassword, session);
        if (((String)resultJson.get("isWork")).equalsIgnoreCase("yes")) {
            modelAndView.setViewName("redirect:/login.jsp");
            return modelAndView;
        }
        else {
            modelAndView.addObject("retrievepas", "找回密码失败");
            modelAndView.setViewName("/retrievepas");
            return modelAndView;
        }
    }

    /**
     * 发送邮件验证码并处理验证码时效问题
     * @param request
     * @param email
     * @throws MessagingException
     */
    @RequestMapping(value = "/getemailauthcode", method = RequestMethod.GET)
    public void SendAuthCodeEmail(HttpServletRequest request, String email) {
        HttpSession session = request.getSession(false);
        emailinterface.SendVerificationCodeEmail(email, true, session);
        emailinterface.VerificationCodeExpired(session);
    }

    /**
     * 从spring security获取用户名
     * @return
     */
    public static Login getPrincipal(){
        try {
            return (Login) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
