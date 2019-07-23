package com.demoproject.controller.membershipType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MembershipController {

    @GetMapping(value = "/membership-list")
    public String membershipList(){
        return "membership/membership-list";
    }

    @GetMapping(value = "/membership-add")
    public String addMembership(){
        return "membership/add";
    }
}
