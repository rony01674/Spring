package com.demoproject.controller.workoutManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkoutManagementController {

    @GetMapping(value = "/add-body-measurement")
    public String addMeasurement(){
        return "workoutManagement/add-measurement";
    }

    @GetMapping(value = "/workout-list")
    public String viewMeasurement(){
        return "workoutManagement/workout-list";
    }

    @GetMapping(value = "/add-workout")
    public String addDailyWorkout(){
        return "workoutManagement/add-daily-workout";
    }
}
