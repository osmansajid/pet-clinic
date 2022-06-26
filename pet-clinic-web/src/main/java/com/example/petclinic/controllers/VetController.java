package com.example.petclinic.controllers;

import com.example.petclinic.services.map.VetServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetController {
    private VetServiceMap vetService;

    public VetController(VetServiceMap vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listOfVets(Model model){
        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }
}
