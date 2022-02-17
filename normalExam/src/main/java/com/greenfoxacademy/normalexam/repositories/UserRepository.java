package com.greenfoxacademy.normalexam.repositories;

import com.greenfoxacademy.normalexam.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndSecretEquals(String username,String secret);
    User findByUsernameEquals(String username);

}
