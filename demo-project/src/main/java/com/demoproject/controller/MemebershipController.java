package com.demoproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemebershipController {

    @GetMapping(value = "/membership-list")
    public String membershipList(){
        return "membership/membership-type";
    }

    @GetMapping(value = "/membership-add")
    public String addMembership(){
        return "membership/add";
    }
}
