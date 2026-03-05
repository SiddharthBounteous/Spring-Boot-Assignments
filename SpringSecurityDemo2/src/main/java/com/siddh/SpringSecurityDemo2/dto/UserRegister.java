package com.siddh.SpringSecurityDemo2.dto;

import com.siddh.SpringSecurityDemo2.repository.UserRepository;

public class UserRegister {
    private String username;
    private String password;
    private String role;
    public UserRegister(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
