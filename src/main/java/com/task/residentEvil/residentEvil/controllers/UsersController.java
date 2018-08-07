package com.task.residentEvil.residentEvil.controllers;

import com.task.residentEvil.residentEvil.entity.Users;
import com.task.residentEvil.residentEvil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsersController {


    @Autowired
    UserService userService;


    @GetMapping("/users")
    public String getAllUsers(Model model){
        List<Users> usersList = this.userService.getAllUsersList();
        model.addAttribute("usersList",usersList);
        return "users";
    }
}
