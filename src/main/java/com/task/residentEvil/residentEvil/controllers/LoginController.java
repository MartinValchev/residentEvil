package com.task.residentEvil.residentEvil.controllers;

import com.task.residentEvil.residentEvil.model.RegisterBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    @GetMapping("/register")
    public  String getRegisterPage(@ModelAttribute  RegisterBindingModel registerBindingModel){
        return "register";
    }
}
