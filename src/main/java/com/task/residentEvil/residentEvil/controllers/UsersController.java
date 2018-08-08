package com.task.residentEvil.residentEvil.controllers;

import com.task.residentEvil.residentEvil.entity.Roles;
import com.task.residentEvil.residentEvil.entity.Users;
import com.task.residentEvil.residentEvil.model.UsersBindingModel;
import com.task.residentEvil.residentEvil.service.RolesService;
import com.task.residentEvil.residentEvil.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
public class UsersController {


    @Autowired
    UserService userService;

    @Autowired
    RolesService rolesService;

    @Autowired
    ModelMapper modelMapper;


    @GetMapping("/users")
    public String getAllUsers(Model model){
        List<Users> usersList = this.userService.getAllUsersList();
        model.addAttribute("usersList",usersList);
        return "users";
    }

    @GetMapping("/editUser/{id}")
    public String getEdtiUsersPage(@PathVariable("id") Long id,@ModelAttribute UsersBindingModel usersBindingModel, Model model){
        Users editUser = userService.getUserById(id);
        usersBindingModel = modelMapper.map(editUser,UsersBindingModel.class);
        usersBindingModel.setIsAccountNonExpired(editUser.isAccountNonExpired());
        usersBindingModel.setIsAccountNonLocked(editUser.isAccountNonLocked());
        usersBindingModel.setIsCredentialsNonExpired(editUser.isCredentialsNonExpired());
        Set<Roles> rolesSet = rolesService.getRolesSet();
        model.addAttribute("authoritiesList",rolesSet);
        model.addAttribute("usersBindingModel",usersBindingModel);
        return "editUsers";
    }

    @PutMapping("/editUser")
    public String editUser(@Valid @ModelAttribute UsersBindingModel usersBindingModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "editUsers";
        }
        this.userService.updateUser(usersBindingModel);
        return "redirect:/users";
    }
}
