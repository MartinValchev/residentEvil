package com.task.residentEvil.residentEvil.repository;

import com.task.residentEvil.residentEvil.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users,Long>{

    Users findOneByUsername(String username);
}
