package com.task.residentEvil.residentEvil.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
public class Users implements UserDetails {

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

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNotExpired(boolean accountNotExpired) {
        isAccountNotExpired = accountNotExpired;
    }

    public void setAccountNotLocked(boolean accountNotLocked) {
        isAccountNotLocked = accountNotLocked;
    }

    public void setCredentialsNotExpired(boolean credentialsNotExpired) {
        isCredentialsNotExpired = credentialsNotExpired;
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
