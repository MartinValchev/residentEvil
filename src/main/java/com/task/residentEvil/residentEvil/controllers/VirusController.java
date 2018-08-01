package com.task.residentEvil.residentEvil.controllers;

import com.task.residentEvil.residentEvil.entity.Capitals;
import com.task.residentEvil.residentEvil.entity.Magnitude;
import com.task.residentEvil.residentEvil.entity.Mutation;
import com.task.residentEvil.residentEvil.model.VirusBindingModel;
import com.task.residentEvil.residentEvil.service.CapitalsService;
import com.task.residentEvil.residentEvil.service.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class VirusController {

    @Autowired
    CapitalsService capitalsService;

    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }
    @GetMapping("/add")
    public String addVirus(VirusBindingModel virusBindingModel, Model model){
        List<Mutation> mutationList = Stream.of(Mutation.values()).collect(Collectors.toList());
        List<Magnitude> magnitudeList = Stream.of(Magnitude.values()).collect(Collectors.toList());
        List<Capitals> capitalsList = capitalsService.getCapitalsList();
        model.addAttribute("allMutations",mutationList);
        model.addAttribute("magnitudeList",magnitudeList);
        model.addAttribute("capitalsList",capitalsList);
        return "AddVirus";
    }
}
