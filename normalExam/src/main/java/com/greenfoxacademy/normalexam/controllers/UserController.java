package com.greenfoxacademy.normalexam.controllers;

import com.greenfoxacademy.normalexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}")
    public String profileShow(@PathVariable(required = false) String id, Model model) {
        try {
            if (id.isEmpty() || userService.getById(Long.parseLong(id)) == null
                    || Long.parseLong(id) > userService.getById(Long.parseLong(id)).getMeal().size()) {
                model.addAttribute("userNotFound", UserService.getUserNotFound());
            } else {
                model.addAttribute("user", userService.getById(Long.parseLong(id)));
            }
        } catch (Exception e) {
            model.addAttribute("userNotFound", UserService.getUserNotFound());
        }
        return "userProfile";
    }
}
