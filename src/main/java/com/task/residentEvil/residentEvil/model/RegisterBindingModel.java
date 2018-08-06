package com.task.residentEvil.residentEvil.model;

import javax.validation.constraints.Size;

public class RegisterBindingModel {

    @Size(min=5,message = "Username cannot be less than 5 characters")
    private String username;

    @Size(min=5, message="Password cannot be less than 5 characters")
    private String password;

    private String confirmedPassword;

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

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
}
