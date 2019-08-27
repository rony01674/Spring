package com.demoproject.controller.attendanceManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttendanceController {

    @GetMapping(value = "/attendance")
    public String showAttendance() {
        return "attendance-management/add-view-attendance";
    }

    @GetMapping(value = "/add-class-time")
    public String addClass() {
        return "attendance-management/add-class";
    }

    @GetMapping(value = "/class-time")
    public String viewClass(){
        return "attendance-management/view-class";
    }
}

