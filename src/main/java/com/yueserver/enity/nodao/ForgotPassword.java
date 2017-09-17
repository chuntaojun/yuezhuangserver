package com.yueserver.enity.nodao;

public class ForgotPassword {

    private String username;
    private String email;
    private String authcode;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ForgotPassword{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", authcode='" + authcode + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
