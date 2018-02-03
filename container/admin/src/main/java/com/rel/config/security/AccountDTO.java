package com.rel.config.security;

import java.util.List;

public class AccountDTO {
    String userName;
    List<String> roles;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public AccountDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public AccountDTO(String userName, List<String> roles) {
        this.userName = userName;
        this.roles = roles;
    }
}
