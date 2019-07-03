package com.springprojectexample.controller;

import com.springprojectexample.entity.Department;
import com.springprojectexample.entity.Student;
import com.springprojectexample.repositories.DepartmentRepo;
import com.springprojectexample.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {

    @Autowired
    private StudentRepo repo;

    @Autowired
    private DepartmentRepo departmentRepo;

    // This method is using for Showing Student page
    @GetMapping(value = "/student")
    public String displayStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("list", this.repo.findAll());
        model.addAttribute("depList", this.departmentRepo.findAll());
        return "student";
    }

    //This method is using for saving data to database from Student page
    @PostMapping(value = "/student")
    public String save(Model model, @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("errMsg", "Something is wrong");
        } else {
            this.repo.save(student);
            model.addAttribute("successMsg", "Data Save Successfully");
            model.addAttribute("stuList", this.repo.findAll());
            model.addAttribute("depList", this.departmentRepo.findAll());
        }
        return "student";
    }

}
