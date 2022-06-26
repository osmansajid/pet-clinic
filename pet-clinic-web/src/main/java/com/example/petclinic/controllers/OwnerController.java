package com.example.petclinic.controllers;

import com.example.petclinic.services.map.OwnerServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private OwnerServiceMap ownerServiceMap;

    public OwnerController(OwnerServiceMap ownerServiceMap) {
        this.ownerServiceMap = ownerServiceMap;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listOfOwners(Model model){
        model.addAttribute("owners",ownerServiceMap.findAll());
        return "owners/index";
    }
}
