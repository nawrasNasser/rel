package com.rel.admin.api;

import com.rel.admin.config.security.AdminUserDetailsService;
import com.rel.admin.config.security.AdminUserPrincipal;
import com.rel.admin.config.security.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApiIgnore
@Controller
public class MainController {

//    @Autowired
//    private AuthenticationProvider authenticationProvider;
//    @Autowired
//    AdminUserDetailsService adminUserDetailsService;
//
//    @RequestMapping(value={"/api/auth/login"},method = RequestMethod.POST,
//      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
//      produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//	public String login(@RequestParam(value = "username",required = true) String username,
//                        @RequestParam(value="password", required = true) String password) {
//
//      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username,password);
//      Authentication yy= authenticationProvider.authenticate(usernamePasswordAuthenticationToken);
//
//     AdminUserPrincipal y=   adminUserDetailsService.getCurrentUser();
//
//		return "OK";
//	}

}
