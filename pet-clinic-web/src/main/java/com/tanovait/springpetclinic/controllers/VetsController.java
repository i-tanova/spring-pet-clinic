package com.tanovait.springpetclinic.controllers;

import com.tanovait.springpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsController {

    private final VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"vets", "vets/index", "vets/index.html", "/vets.html"})
    String listVets(Model model){
        model.addAttribute("vets", vetService.getAll());
        return "vets/index";
    }
}
