package com.thymeleafetemplate.controller;

import com.thymeleafetemplate.entity.User;
import com.thymeleafetemplate.repository.RoleRepo;
import com.thymeleafetemplate.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //this variable is used for photo path
    private final String UPLOADED_FOLDER = "src/main/resources/static/upload/";

    @GetMapping(value = "/signup")
    public String displayUser(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("roleList", this.roleRepo.findAll());
        return "user";
    }

    @PostMapping(value = "/signup")
    public String signUp(@Valid User user, BindingResult bindingResult,
                         @RequestParam(value = "photo")MultipartFile photo, Model model) throws IOException{
        if (bindingResult.hasErrors()){
            model.addAttribute("errMsg","Something is wrong");
        }
        user.setPhotoPath("/upload/"+photo.getOriginalFilename());
        //for photo upload
        byte[] bytes = photo.getBytes();
        Path path = Paths.get(UPLOADED_FOLDER+photo.getOriginalFilename());
        Files.write(path, bytes);
        //photo upload end
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepo.save(user);
        model.addAttribute("sucMsg","Success");
        return "user";
    }

}
