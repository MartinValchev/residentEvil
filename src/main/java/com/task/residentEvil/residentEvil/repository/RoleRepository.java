package com.task.residentEvil.residentEvil.repository;

import com.task.residentEvil.residentEvil.entity.Roles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Roles,Long>{

    @Query("select e from Roles e")
    Set<Roles> getRolesSet();
}
