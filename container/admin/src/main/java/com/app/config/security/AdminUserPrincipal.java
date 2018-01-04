package com.app.config.security;

import com.rel.persistence.model.admin.AdminUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdminUserPrincipal implements UserDetails {
    private AdminUser user;

    public AdminUserPrincipal(AdminUser user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auth = new ArrayList<>();
        this.user.getRoles().forEach(r->{
            auth.add(new SimpleGrantedAuthority(r.getName().name()));
        });
        return auth;
    }

    @Override
    public String getPassword() {
       return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.user.getActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return  this.user.getActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.user.getActive();
    }

    @Override
    public boolean isEnabled() {
         return this.user.getActive();
    }

    List<String> getRoles(){
        List<String> list = new ArrayList<>();
        this.user.getRoles().forEach(r->{
            list.add(r.getName().name());
        });
        return list;

    }
}
