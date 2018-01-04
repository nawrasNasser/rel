package com.rel.persistence.model.admin;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "admin_user")
public class AdminUser {

    @Id
    private Long id;

    @Column(name = "password")
    String password;

    @Column(name = "name")
    String name;
    @Column(name = "email")
    String email;
    @Column(name = "is_active")
    Boolean isActive;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "admin_user_to_role", joinColumns = @JoinColumn(name = "admin_user_id"),
        inverseJoinColumns = @JoinColumn(name = "admin_role_id"))
    private Set<AdminUserRole> roles = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Set<AdminUserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AdminUserRole> roles) {
        this.roles = roles;
    }
}
