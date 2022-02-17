package com.greenfoxacademy.normalexam.service;

import com.greenfoxacademy.normalexam.models.Meal;
import com.greenfoxacademy.normalexam.models.Type;

import java.util.List;

public interface MealService {
    List<Meal> findAll();

    List<Meal> findByTitleAndType(String title, Type type);

    List<Meal> findByTitle(String title);

    List<Type> findByType(Type type);

    Meal getById(Long id);

    void save(Meal meal);

    void delete(Meal meal);

    static String getBadRequestError() {
        return "Error: Bad request - missing crucial data!";
    }

    static String getMealNotFoundMsg(){return "Error: No such meal was found!";}

    static String getSuccessMsgMealWasDeleted(){return "Success: Meal was deleted!";}
}
