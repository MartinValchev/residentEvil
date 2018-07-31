package com.task.residentEvil.residentEvil.service;

import com.task.residentEvil.residentEvil.entity.Virus;

import java.util.List;

public interface VirusService {
    List<Virus> getAllVirusList();

    Virus getVirusById(Long id);

    Virus addVirus(Virus virus);

    void removeVirus(Virus virus);

    void editVirus(Virus virus);
}
