package com.task.residentEvil.residentEvil.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean isAccountNotExpired;
    private boolean isAccountNotLocked;
    private boolean isCredentialsNotExpired;
    private boolean isEnabled;

    @ManyToMany
    @JoinTable(name = "users_roles",joinColumns ={@JoinColumn(name="user_id")},
            inverseJoinColumns ={@JoinColumn(name ="role_id")} )
    private List<Roles> roles= new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAccountNotExpired() {
        return isAccountNotExpired;
    }

    public void setAccountNotExpired(boolean accountNotExpired) {
        isAccountNotExpired = accountNotExpired;
    }

    public boolean getIsAccountNotLocked() {
        return isAccountNotLocked;
    }

    public void setAccountNotLocked(boolean accountNotLocked) {
        isAccountNotLocked = accountNotLocked;
    }

    public boolean getIsCredentialsNotExpired() {
        return isCredentialsNotExpired;
    }

    public void setCredentialsNotExpired(boolean credentialsNotExpired) {
        isCredentialsNotExpired = credentialsNotExpired;
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
