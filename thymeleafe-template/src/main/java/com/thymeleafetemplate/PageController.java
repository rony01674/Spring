package com.thymeleafetemplate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    //for index page
    @GetMapping(value = "/")
    public String index() {
        return "index";
    }
}

