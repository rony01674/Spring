package com.demoproject.controller.attendanceManagement;

import com.demoproject.entity.attendanceManagement.ClassSchedule;
import com.demoproject.repository.attendanceManagement.ClassScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AttendanceController {

    @Autowired
    private ClassScheduleRepo repo;

    @GetMapping(value = "/attendance")
    public String showAttendance() {
        return "attendance-management/add-view-attendance";
    }


    @GetMapping(value = "/add-class-time")
    public String addClass(Model model) {

        model.addAttribute("classTime", new ClassSchedule());
//        model.addAttribute("list", this.repo.findAll());
        return "attendance-management/add-class";
    }

    @PostMapping(value = "/add-class-time")
    public String saveClass(Model model, @Valid ClassSchedule classTime){

        this.repo.save(classTime);
        model.addAttribute("classTime", new ClassSchedule());
        //model.addAttribute("successMsg","Class Time Saved");
        //model.addAttribute("list", repo.findAll());
        return "attendance-management/add-class";
    }

    @GetMapping(value = "/class-time")
    public String viewClass(){
        return "attendance-management/view-class";
    }
}

