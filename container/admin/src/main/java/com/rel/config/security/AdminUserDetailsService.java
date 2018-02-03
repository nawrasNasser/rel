package com.rel.config.security;


import com.rel.persistence.model.admin.AdminUser;
import com.rel.persistence.repo.AdminUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AdminUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminUserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<AdminUser> user = userRepository.findByEmail(username);
        if (user.get() == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AdminUserPrincipal(user.get());
    }

    public AdminUserPrincipal getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated())
            return null;

        return  (AdminUserPrincipal) authentication.getPrincipal();
    }


    public AccountDTO getAccountDTO(){
        AdminUserPrincipal precipals = getCurrentUser();
        return new AccountDTO(precipals.getUsername(),precipals.getRoles());
    }
}
