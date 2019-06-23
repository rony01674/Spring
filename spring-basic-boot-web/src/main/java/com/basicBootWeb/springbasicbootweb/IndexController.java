package com.basicBootWeb.springbasicbootweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(value = "/")
    public String home(Model model){
        model.addAttribute("welcome", "Hello MVC");
        return "index";
    }

    @GetMapping(value = "/about.bd")
    public String about(Model model){
        model.addAttribute("welcome", "About us");
        return "about";
    }

    @GetMapping(value = "/contact.php")
    public String contact(Model model){
        model.addAttribute("welcome", "Contact us");
        return "contact";
    }
}
