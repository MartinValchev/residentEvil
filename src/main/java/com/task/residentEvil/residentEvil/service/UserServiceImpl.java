package com.task.residentEvil.residentEvil.service;

import com.task.residentEvil.residentEvil.entity.Users;
import com.task.residentEvil.residentEvil.model.RegisterBindingModel;
import com.task.residentEvil.residentEvil.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void register(RegisterBindingModel registerBindingModel) {
        Users user = this.modelMapper.map(registerBindingModel, Users.class);
        String encryptedPassword = this.bCryptPasswordEncoder.encode(registerBindingModel.getPassword());
        user.setPassword(encryptedPassword);
        user.setAccountNotExpired(true);
        user.setAccountNotLocked(true);
        user.setEnabled(true);
        user.setCredentialsNotExpired(true);
        usersRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user =this.usersRepository.findOneByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}