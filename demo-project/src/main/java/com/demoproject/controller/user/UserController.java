package com.demoproject.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value = "/staff-member-list")
    public String showStaffList(){
        return "user/user-list";
    }

    @GetMapping(value = "/add-staff-member")
    public String addStaff(){
        return "user/add-user";
    }
}
