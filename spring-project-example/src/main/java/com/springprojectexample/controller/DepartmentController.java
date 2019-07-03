package com.springprojectexample.controller;

import com.springprojectexample.entity.Department;
import com.springprojectexample.repositories.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentRepo repo;

    // This method is using for Showing Index page
    @GetMapping(value = "/")
    public String displayIndex(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("list", this.repo.findAll());
        return "index";
    }

    //This method is using for saving data to database from Index page
    @PostMapping(value = "/")
    public String save(Model model, @Valid Department department, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("errMsg", "Something is wrong");
        } else {
            this.repo.save(department);
            model.addAttribute("successMsg", "Data Save Successfully");
            model.addAttribute("list", this.repo.findAll());
        }
        return "index";
    }
}
