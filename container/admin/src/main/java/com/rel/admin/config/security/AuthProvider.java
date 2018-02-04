package com.rel.admin.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;


public class AuthProvider extends AbstractUserDetailsAuthenticationProvider {


    private AdminUserDetailsService adminUserDetailsService;

    private PasswordEncoder passwordEncoder;

    private RegistrationService registrationService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        if(authentication.getCredentials() == null){
            throw new BadCredentialsException("bad credentials!");
        }

        String presentedPassword = authentication.getCredentials().toString();


        boolean loginSuccess = registrationService.isLoginSuccess(userDetails, presentedPassword);

        if(!loginSuccess){
            throw new BadCredentialsException("Bad credentials");
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        final UserDetails userDetails;

        try {
            userDetails = this.adminUserDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e){
            throw e;
        } catch (Exception other){
            throw new InternalAuthenticationServiceException("internal error", other);
        }

        if (userDetails == null) {
            throw new InternalAuthenticationServiceException("User details Must not be null");
        }

        return userDetails;
    }

    @Autowired
    public void setAdminUserDetailsService(AdminUserDetailsService adminUserDetailsService) {
        this.adminUserDetailsService = adminUserDetailsService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
}
