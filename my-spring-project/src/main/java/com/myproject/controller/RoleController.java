package com.myproject.controller;

import com.myproject.entity.Role;
import com.myproject.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {

    @Autowired
    private RoleRepo repo;

    @GetMapping(value = "/role-save")
    public String saveRole(){
        Role role = new Role();
        role.setRoleName("ADMIN");
        repo.save(role);

        Role role2 = new Role();
        role.setRoleName("User");
        repo.save(role2);
        return "Success";
    }
}
