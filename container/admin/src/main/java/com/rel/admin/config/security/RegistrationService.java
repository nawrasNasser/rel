package com.rel.admin.config.security;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private static final String SECRET_TOKEN = "AU!R7-0=@mJ;aNc+xZy";

    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String generatePassword(String username, String password){

        Preconditions.checkNotNull(username, "Логин не должен быть NULL");
        Preconditions.checkNotNull(password, "Пароль не должен быть NULL");

        return passwordEncoder.encode(getRawPassword(username, password));
    }

    public boolean isLoginSuccess(UserDetails userDetails, String presentedPassword) {
        return passwordEncoder.matches(getRawPassword(userDetails.getUsername(), presentedPassword), userDetails.getPassword());
    }

    public boolean isLoginSuccess(String username, String userPassword, String presentedPassword) {
        return passwordEncoder.matches(getRawPassword(username, presentedPassword), userPassword);
    }

    private String getRawPassword(String username, String presentedPassword) {
        return username + presentedPassword + SECRET_TOKEN;
    }

}
