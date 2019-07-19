package com.demoproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping(value = "/")
    public String displayIndex(){
        return "index";
    }

    @GetMapping(value = "login")
    public String login(){
        return "login";
    }
}
