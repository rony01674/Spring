package com.demoproject.controller.nutritionManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NutritionController {

    @GetMapping(value = "/add-nutrition")
    public String addNutrition() {
        return "nutrition-management/assign-nutrition";
    }

    @GetMapping(value = "/nutrition-list")
    public String showNutritionList(){
        return "nutrition-management/nutrition-list";
    }
}
