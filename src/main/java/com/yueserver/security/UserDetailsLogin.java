package com.yueserver.security;

import com.yueserver.adaper.MethodNourtFoundException;
import com.yueserver.adaper.encryption.base64.Base64;
import com.yueserver.bean.Administator;
import com.yueserver.bean.nodao.Login;
import com.yueserver.bean.Merchant;
import com.yueserver.security.excption.AccountNotFoundException;
import com.yueserver.security.excption.PendingReviewException;
import com.yueserver.security.excption.ProhibitLandingException;
import com.yueserver.service.LoginInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.yueserver.adaper.AdaperFactory.getSingleAdaperFactory;

public class UserDetailsLogin implements UserDetailsService {

    @Autowired
    @Resource(name = "LoginProcess")
    private LoginInterface loginservice;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = null;
        List list = null;
        try {
            list = (List) loginservice.getLoginObject(username);
        } catch (MethodNourtFoundException e) {
            e.printStackTrace();
        }
        if (list.size() == 0)
            throw new AccountNotFoundException("用户名或密码错误");
        Object[] objects = (Object[]) list.iterator().next();
        Administator administator = (Administator) objects[0];
        Merchant merchant = (Merchant) objects[1];
        if (getBase64().Base64Decode(merchant.getMctaccount()).equals(username)) {
            login = new Login(username, merchant.getMctpassword(), AccountStatus(merchant),
                    true, true, true, getGrantedAuthorities(merchant));
            if (merchant.getMctstate() == 0)
                throw new PendingReviewException("账户待审核");
            if (merchant.getMctstate() == -1)
                throw new ProhibitLandingException("当前账户被禁止");
            login.setMctno(merchant.getMctno());
            login.setStatus(merchant.getMctstate());
        }
        else if (getBase64().Base64Decode(administator.getAdmaccount()).equals(username))
            login = new Login(username, administator.getAdmpassword(), true, true, true,
                    true, getGrantedAuthorities(administator));
        return login;
    }

    /**
     * 账户权限信息
     * @return
     */
    private List<GrantedAuthority> getGrantedAuthorities(Object o){
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (o instanceof Merchant) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        if (o instanceof Administator)
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorities;
    }

    /**
     * 商家账户状态
     * @param merchant
     * @return
     */
    private boolean AccountStatus(Merchant merchant) {
        if (merchant.getMctstate() == 1)
            return true;
        return false;
    }

    private Base64 getBase64() {
        try {
            return (Base64) getSingleAdaperFactory().getEncryption("Base64");
        } catch (MethodNourtFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
