package com.tanovait.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnersController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    String listAll(){
        return "owners/index";
    }
}
