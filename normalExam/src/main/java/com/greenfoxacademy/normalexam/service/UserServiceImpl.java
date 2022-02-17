package com.greenfoxacademy.normalexam.service;

import com.greenfoxacademy.normalexam.models.User;
import com.greenfoxacademy.normalexam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsernameEquals(username);
    }

    @Override
    public Boolean check(String username, String secret) {
        return userRepository.findByUsernameAndSecretEquals(username, secret) != null;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }


}
