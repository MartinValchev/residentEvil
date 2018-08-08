package com.task.residentEvil.residentEvil.service;

import com.task.residentEvil.residentEvil.entity.Users;
import com.task.residentEvil.residentEvil.model.RegisterBindingModel;
import com.task.residentEvil.residentEvil.model.UsersBindingModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService{
    void register(RegisterBindingModel registerBindingModel);

    List<Users> getAllUsersList();

    Users getUserById(Long id);

    void updateUser(UsersBindingModel usersBindingModel);
}
