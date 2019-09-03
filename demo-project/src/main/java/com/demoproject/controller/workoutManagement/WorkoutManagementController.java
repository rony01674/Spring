package com.demoproject.controller.workoutManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkoutManagementController {

    @GetMapping(value = "/add-body-measurement")
    public String addMeasurement(){
        return "workout-management/add-measurement";
    }

    @GetMapping(value = "/workout-list")
    public String viewMeasurement(){
        return "workout-management/workout-list";
    }

    @GetMapping(value = "/add-workout")
    public String addDailyWorkout(){
        return "workout-management/assign-workout";
    }
}
