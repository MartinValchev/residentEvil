package com.task.residentEvil.residentEvil.service;

import com.task.residentEvil.residentEvil.entity.Roles;
import com.task.residentEvil.residentEvil.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class RolesServiceImpl implements  RolesService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Set<Roles> getRolesSet() {
        return roleRepository.getRolesSet();
    }
}
