package com.greenfoxacademy.normalexam.controllers;

import com.greenfoxacademy.normalexam.service.MealService;
import com.greenfoxacademy.normalexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final MealService mealService;
    private final UserService userService;

    @Autowired
    public HomeController(MealService mealService, UserService userService) {
        this.mealService = mealService;
        this.userService = userService;
    }

    @GetMapping(path = "/")
    public String tableMeals(Model model) {
        model.addAttribute("meals", mealService.findAll());
        return "tableMeals";
    }
}
