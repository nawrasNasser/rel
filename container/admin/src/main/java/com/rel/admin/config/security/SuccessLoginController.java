package com.rel.admin.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@Slf4j
@ApiIgnore
public class SuccessLoginController{

    private AdminUserDetailsService adminUserDetailsService;

    public
    @ResponseBody
    @RequestMapping(value={"/api/account"},method = RequestMethod.POST)
    AccountDTO account(){
        return adminUserDetailsService.getAccountDTO();
    }

    @Autowired
    public void setAdminUserDetailsService(AdminUserDetailsService adminUserDetailsService) {
        this.adminUserDetailsService = adminUserDetailsService;
    }
}
