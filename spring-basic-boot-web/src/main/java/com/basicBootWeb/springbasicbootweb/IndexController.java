package com.basicBootWeb.springbasicbootweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
public class IndexController {

    @Autowired
    private StudentRepository repository;

    //for home page
    @GetMapping(value = "/")
    public String home(Model model) {
        //For saving random data
        //this.repository.save(new Student(UUID.randomUUID().toString()));
        model.addAttribute("welcome", "Hello MVC");
        model.addAttribute("student", new Student());
        return "index";
    }

    //for index page connected with list page
    @PostMapping(value = "/")
    public String saveStudent(Model model, @Valid Student student){
        this.repository.save(student);
        model.addAttribute("success", "Save Successful");
        return "redirect:/list";
    }

    //for list page
    @GetMapping(value = "/list")
    public String getStudentList(Model model) {
        List<Student> studentList = this.repository.findAll();
        model.addAttribute("sList", studentList);
        return "list";
    }

    //For studentList page
    @GetMapping(value = "/studentList")
    public ModelAndView displayStudents() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentList", this.repository.findAll());
        modelAndView.setViewName("studentList");
        return modelAndView;
    }

    //for student page
    @GetMapping(value = "/student/{id}")
    public String getStudentById(Model model, @PathVariable("id") Long id) {
        Student s = this.repository.getOne(id);
        model.addAttribute("stu", s);
        return "student";
    }

//    //for student2 page
//    @GetMapping(value = "/student2")
//    public String displayStudentById(Model model, @RequestParam(name = "id", required = false, defaultValue = "1") Long id) {
//        Student s = this.repository.getOne(id);
//        model.addAttribute("stu", s);
//        return "student2";
//    }




    //For about page
    @GetMapping(value = "/about")
    public String about(Model model) {
        model.addAttribute("welcome", "About us");
        return "about";
    }

    //for contact page
    @GetMapping(value = "/contact")
    public String contact(Model model) {
        model.addAttribute("welcome", "Contact us");
        return "contact";
    }
}
