package com.app.repo;


import com.app.model.admin.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminUserRepo extends JpaRepository<AdminUser, Long>{

    Optional<AdminUser> findByEmailAndPassword(String email, String password);

    Optional<AdminUser> findByEmail(String email);

}
