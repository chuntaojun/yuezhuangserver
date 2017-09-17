package com.yueserver.enity.nodao;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by liaochuntao on 17-7-12.
 */
public class Login extends User {

    private String role;
    private String email;
    private int mctno;
    private int status;

    public Login(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public String getRole(Collection<? extends GrantedAuthority> authorities) {
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority grantedAuthority = iterator.next();
        return grantedAuthority.getAuthority();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMctno() {
        return mctno;
    }

    public void setMctno(int mctno) {
        this.mctno = mctno;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Login{" +
                "role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", mctno=" + mctno +
                ", status=" + status +
                '}';
    }
}
