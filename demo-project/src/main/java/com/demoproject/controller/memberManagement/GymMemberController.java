package com.demoproject.controller.memberManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GymMemberController {

    @GetMapping(value = "/members-list")
    public String showGymMemberList(){
        return "gym-member/members-list";
    }

    @GetMapping(value = "/add-member")
    public String addMember(){
        return "gym-member/add-member";
    }

    @GetMapping(value = "/member-profile")
    public String memberProfile(){
        return "gym-member/member-profile";
    }
}
