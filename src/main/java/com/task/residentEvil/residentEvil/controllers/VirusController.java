package com.task.residentEvil.residentEvil.controllers;

import com.task.residentEvil.residentEvil.entity.Capitals;
import com.task.residentEvil.residentEvil.entity.Magnitude;
import com.task.residentEvil.residentEvil.entity.Mutation;
import com.task.residentEvil.residentEvil.entity.Virus;
import com.task.residentEvil.residentEvil.model.VirusBindingModel;
import com.task.residentEvil.residentEvil.repository.VirusRepository;
import com.task.residentEvil.residentEvil.service.CapitalsService;
import com.task.residentEvil.residentEvil.service.VirusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class VirusController {

    @Autowired
    CapitalsService capitalsService;

    @Autowired
    VirusRepository virusRepository;

    @Autowired
    VirusService virusService;

    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }
    @GetMapping("/add")
    public String getAddVirus(VirusBindingModel virusBindingModel, Model model){
        List<Mutation> mutationList = Stream.of(Mutation.values()).collect(Collectors.toList());
        List<Magnitude> magnitudeList = Stream.of(Magnitude.values()).collect(Collectors.toList());
        List<Capitals> capitalsList = capitalsService.getCapitalsList();
        model.addAttribute("allMutations",mutationList);
        model.addAttribute("magnitudeList",magnitudeList);
        model.addAttribute("capitalsList",capitalsList);
        return "AddVirus";
    }
    @GetMapping("/virus/{id}")
    public String getVirus(@PathVariable("id") Long id,Model model){
        Virus virus = virusService.getVirusById(id);
        model.addAttribute("virus",virus);
        return "VirusById";
    }

    @PostMapping("/add")
    public String addVirus(@Valid @ModelAttribute VirusBindingModel virusBindingModel, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            List<Mutation> mutationList = Stream.of(Mutation.values()).collect(Collectors.toList());
            List<Magnitude> magnitudeList = Stream.of(Magnitude.values()).collect(Collectors.toList());
            List<Capitals> capitalsList = capitalsService.getCapitalsList();
            model.addAttribute("allMutations",mutationList);
            model.addAttribute("magnitudeList",magnitudeList);
            model.addAttribute("capitalsList",capitalsList);
            model.addAttribute("virusBindingModel",virusBindingModel);
            return "AddVirus";
        }else{
            ModelMapper modelMapper = new ModelMapper();
            Virus virus =modelMapper.map(virusBindingModel,Virus.class);
            Virus savedVirus = virusRepository.save(virus);
            return "redirect:virus/" +  savedVirus.getId();
        }
    }
}
