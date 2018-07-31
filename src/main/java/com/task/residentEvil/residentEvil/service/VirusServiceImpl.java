package com.task.residentEvil.residentEvil.service;


import com.task.residentEvil.residentEvil.entity.Virus;
import com.task.residentEvil.residentEvil.repository.VirusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VirusServiceImpl implements VirusService {

    @Autowired
    private VirusRepository virusRepository;

    @Override
    public List<Virus> getAllVirusList() {
        return virusRepository.getAllVirusList();
    }

    @Override
    public Virus getVirusById(Long id) {
        return virusRepository.getVirusById(id);
    }

    @Override
    public Virus addVirus(Virus virus) {
        Virus savedVirus = virusRepository.save(virus);
        return savedVirus;
    }

    @Override
    public void removeVirus(Virus virus) {
        virusRepository.delete(virus);
    }

    @Override
    public void editVirus(Virus virus) {
        virusRepository.save(virus);
    }
}
