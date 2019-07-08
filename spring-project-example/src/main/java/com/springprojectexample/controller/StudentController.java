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
import org.springframework.web.bind.annotation.RequestParam;

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

    //This method is use for studentByDep.html page
    @GetMapping(value = "/stubydepid")
    public String displayStudentsByDepartment(Model model, @RequestParam(value = "depid", required = false,
            defaultValue = "1") Long id) {
        model.addAttribute("dlist", this.departmentRepo.findAll());
        Department department = new Department();
        department.setId(id);
        model.addAttribute("listByDep", this.repo.findAllByDepartment(department));

        return "studentByDep";
    }

    //This method is use for profile.html page
    @GetMapping(value = "/profile")
    public String displayStudentsById(Model model, @RequestParam(value = "studentid", required = false,
            defaultValue = "1") Long id) {
        model.addAttribute("stuList", this.repo.findAll());
        model.addAttribute("profile", this.repo.getOne(id));

        return "profile";
    }

    //This method is use for studentByAge.html page
    @GetMapping(value = "/age")
    public String displayStudentsByAge(Model model, @RequestParam(value = "age", required = false,
            defaultValue = "23") int age) {
        model.addAttribute("stuList", this.repo.findAllByAgeGreaterThanEqual(age));

        return "studentByAge";
    }


    //This method is use for studentByDepAndGender.html page
    @GetMapping(value = "/stubygdepandgender")
    public String displayByDepartmentAndGender(Model model, @RequestParam(value = "depId", required = false,
            defaultValue = "1") Long id,@RequestParam(value = "gender", required = false,
            defaultValue = "Male") String gender) {
        Department department = new Department();
        department.setId(id);

        model.addAttribute("dList", this.departmentRepo.findAll());
        model.addAttribute("listByDep", this.repo.findAllByDepartmentAndGender(department, gender));
        model.addAttribute("count",this.repo.countAllByDepartmentAndGender(department,gender));

        return "studentByDepAndGender";
    }

}
