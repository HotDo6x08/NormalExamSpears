package com.greenfoxacademy.normalexam.controllers;

import com.greenfoxacademy.normalexam.models.Meal;
import com.greenfoxacademy.normalexam.models.Type;
import com.greenfoxacademy.normalexam.models.User;
import com.greenfoxacademy.normalexam.service.MealService;
import com.greenfoxacademy.normalexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/meals")
public class MealController {
    private final UserService userService;
    private final MealService mealService;

    @Autowired
    public MealController(UserService userService, MealService mealService) {
        this.userService = userService;
        this.mealService = mealService;
    }

    @GetMapping(path = "/search")
    public String search(@RequestParam(required = false, defaultValue = "") String title, @RequestParam(required = false) String type, Model model) {
        try {
            if (type == null && !title.isEmpty()) {
                model.addAttribute("filteredMeals", mealService.findByTitle(title));
            } else if (type != null && title != null && Type.parse(type) != Type.UNKNOWN) {
                model.addAttribute("filteredMeals", mealService.findByTitleAndType(title, Type.parse(type)));
            } else if (title == null && Type.parse(type) != Type.UNKNOWN) {
                model.addAttribute("filteredMeals", mealService.findByType(Type.parse(type)));
            }
        } catch (Exception e) {
            model.addAttribute("error", "error");
        }
        return "tableMeals";
    }

    @GetMapping(path = "/create")
    public String create(Model model) {
        model.addAttribute("mealTypes", Type.allTypes());
        return "createMeal";
    }

    @PostMapping(path = "/create")
    public String createLogic(@RequestParam(required = false) String titleMeal,
                              @RequestParam(required = false) String username,
                              @RequestParam(required = false) String secret,
                              @RequestParam(required = false) String typeMeal,
                              RedirectAttributes redirectAttributes) {
        try {
            if (titleMeal == null || username == null || secret == null || typeMeal == null) {
                redirectAttributes.addFlashAttribute("error", MealService.getBadRequestError());
                return "redirect:/meals/create";
            } else if (!userService.check(username, secret)) {
                redirectAttributes.addFlashAttribute("error", UserService.getUsernameAndSecretAreNotCorrectError());
                return "redirect:/meals/create";
            } else {
                mealService.save(new Meal(titleMeal, Type.parse(typeMeal), userService.findByUsername(username)));
                redirectAttributes.addFlashAttribute("success", UserService.getUsernameCheckSuccessMsg());
                return "redirect:/user/" + userService.findByUsername(username).getId();
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", MealService.getBadRequestError());
            return "redirect:/meals/create";
        }
    }

    @GetMapping(path = "/{id}")
    public String deleteRender(@PathVariable String id, Model model) {
        try {
            model.addAttribute("meal", mealService.getById(Long.parseLong(id)));
            if (id.isEmpty() || mealService.getById(Long.parseLong(id)) == null) {
                model.addAttribute("error", MealService.getMealNotFoundMsg());
            }
        } catch (Exception e) {
            model.addAttribute("error", MealService.getMealNotFoundMsg());
        }
        return "deleteMeal";
    }

    @PostMapping(path = "{id}")
    public String deleteLogic(@PathVariable(required = false) String id,
                              @RequestParam(required = false) String username,
                              @RequestParam(required = false) String secret,
                              RedirectAttributes redirectAttributes) {
        try {
            if (id == null || username == null || secret == null) {
                redirectAttributes.addFlashAttribute("error", UserService.getUsernameAndSecretAreNotCorrectError());
                return "redirect:/meals/" + id;
            } else {
                if (!userService.check(username, secret)) {
                    redirectAttributes.addFlashAttribute("error", UserService.getUsernameAndSecretAreNotCorrectError());
                    return "redirect:/meals/" + id;
                } else {
                    mealService.delete(mealService.getById(Long.parseLong(id)));
                    redirectAttributes.addFlashAttribute("success", UserService.getUsernameCheckSuccessMsg());
                    return "redirect:/user/" + userService.findByUsername(username).getId();
                }
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", UserService.getUsernameAndSecretAreNotCorrectError());
            return "redirect:/meals/" + id;
        }
    }

}