package com.greenfoxacademy.normalexam.service;

import com.greenfoxacademy.normalexam.models.Meal;
import com.greenfoxacademy.normalexam.models.Type;
import com.greenfoxacademy.normalexam.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public List<Meal> findAll() {
        return mealRepository.findAll();
    }

    @Override
    public List<Meal> findByTitleAndType(String title, Type type) {
        return mealRepository.findByTitleContainingIgnoreCaseAndType(title, type);
    }

    @Override
    public List<Meal> findByTitle(String title) {
        return mealRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Type> findByType(Type type) {
        List<Type> types = Arrays.stream(Type.values()).filter(t -> t.equals(type)).collect(Collectors.toList());
        return types;
    }

    @Override
    public Meal getById(Long id) {
        if (!mealRepository.existsById(id)){
            return null;
        } else {
            return mealRepository.getById(id);
        }
    }

    @Override
    public void save(Meal meal) {
        mealRepository.save(meal);
    }

    @Override
    public void delete(Meal meal) {
        mealRepository.delete(meal);
    }
}
