package com.rel.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/account")
public class SuccessLoginController{

    private AdminUserDetailsService adminUserDetailsService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    AccountDTO account(){

        return adminUserDetailsService.getAccountDTO();
    }

    @Autowired
    public void setAdminUserDetailsService(AdminUserDetailsService adminUserDetailsService) {
        this.adminUserDetailsService = adminUserDetailsService;
    }
}
