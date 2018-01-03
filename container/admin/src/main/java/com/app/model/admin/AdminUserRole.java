package com.app.model.admin;


import javax.persistence.*;

@Entity
@Table(name = "admin_user_role")
public class AdminUserRole {

    public enum Roles {
        admin,
        not_admin
    }

    @Id
    @Column(name = "id")
    private Long id;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "name")
    private Roles name;
    @Column(name = "description")
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Roles getName() {
        return name;
    }

    public void setName(Roles name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
