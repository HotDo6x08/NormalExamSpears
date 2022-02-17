package com.greenfoxacademy.normalexam.service;

import com.greenfoxacademy.normalexam.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User getById(Long id);

    User findByUsername(String username);

    Boolean check(String username, String secret);

    void save(User user);

    static String getUserNotFound(){return "Error: User not found!";}
    static String getUsernameAndSecretAreNotCorrectError(){return "Error: username and secret not correct!";}
    static String getUsernameCheckSuccessMsg(){return "Success: Meal was created!";}
}
