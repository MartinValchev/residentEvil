package com.task.residentEvil.residentEvil.repository;

import com.task.residentEvil.residentEvil.entity.Capitals;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CapitalsRepository extends CrudRepository<Capitals,Long>{

    @Query("SELECT e from Capitals e")
    public List<Capitals> getAllCapitalsList();
}
