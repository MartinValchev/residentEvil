package com.task.residentEvil.residentEvil.controllers;

import com.task.residentEvil.residentEvil.model.RegisterBindingModel;
import com.task.residentEvil.residentEvil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public  String getRegisterPage(@ModelAttribute RegisterBindingModel registerBindingModel){
        return "register";
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false)String error, Model model){
        if(error !=null){
            model.addAttribute("error", "Invalid Credentials");
        }
        return "login";
    }

    @PostMapping("/register")
    public String registerPage(@Valid @ModelAttribute RegisterBindingModel registerBindingModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }else{
            this.userService.register(registerBindingModel);
            return "redirect:/";
        }
    }
    @GetMapping("/unauthorized")
    public String getUnauthorizedPage(){
        return  "unauthorized";
    }
}
