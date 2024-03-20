package com.springwithmongo.listteam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping(value = "/")
    public String index(Model model){
        return "login";
    }

    @GetMapping(value = "/singup")
    public String singup(Model model){
        return "singup";
    }
}
