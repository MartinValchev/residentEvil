package com.task.residentEvil.residentEvil.repository;

import com.task.residentEvil.residentEvil.entity.Virus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VirusRepository extends CrudRepository<Virus,Long> {

    @Query("SELECT e from Virus e")
    public List<Virus> getAllVirusList();
}
