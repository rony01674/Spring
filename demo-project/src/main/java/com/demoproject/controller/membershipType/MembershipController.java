package com.demoproject.controller.membershipType;

import com.demoproject.entity.mebershipTypeManagement.MembershipTypeEntity;
import com.demoproject.repository.attendanceManagement.ClassRepo;
import com.demoproject.repository.membershipTypeManagement.MembershipTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MembershipController {

    @Autowired
    private MembershipTypeRepo repo;

    @Autowired
    private ClassRepo classRepo;


    // This method is used for showing membership list
    @GetMapping(value = "/membership-list")
    public String membershipList(Model model) {

        model.addAttribute("membershipList", this.repo.findAll());
        return "membership/membership-list";
    }

    // This method is for showi
    @GetMapping(value = "/membership-add")
    public String membershipAdd(Model model) {

        model.addAttribute("membershipType", new MembershipTypeEntity());
        model.addAttribute("classList", this.classRepo.findAll());
        return "membership/add";
    }

    @PostMapping(value = "/membership-add")
    public String saveMembership(Model model, @Valid MembershipTypeEntity membershipType, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("errMsg", "Please Enter Valid Data");
        } else {
            this.repo.save(membershipType);
            model.addAttribute("membershipType", new MembershipTypeEntity());
            model.addAttribute("successMge", "Membership Inserted Successful");
            // model.addAttribute("list",this.repo.findAll());
            model.addAttribute("classList", this.classRepo.findAll());
        }
        return "membership/add";

    }

}
