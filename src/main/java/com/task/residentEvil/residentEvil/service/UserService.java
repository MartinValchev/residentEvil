package com.task.residentEvil.residentEvil.service;

import com.task.residentEvil.residentEvil.model.RegisterBindingModel;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{
    void register(RegisterBindingModel registerBindingModel);
}
