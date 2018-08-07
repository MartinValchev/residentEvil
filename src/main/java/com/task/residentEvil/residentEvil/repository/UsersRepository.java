package com.task.residentEvil.residentEvil.repository;

import com.task.residentEvil.residentEvil.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<Users,Long>{

    Users findOneByUsername(String username);

    @Query("SELECT e from Users e")
    List<Users> getAllUsersList();
}
