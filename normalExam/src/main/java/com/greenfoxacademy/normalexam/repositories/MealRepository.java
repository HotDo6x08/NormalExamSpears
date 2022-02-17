package com.greenfoxacademy.normalexam.repositories;

import com.greenfoxacademy.normalexam.models.Meal;
import com.greenfoxacademy.normalexam.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal,Long> {

    List<Meal> findByTitleContainingIgnoreCaseAndType(String title, Type type);

    List<Meal> findByTitleContainingIgnoreCase(String title);
}
