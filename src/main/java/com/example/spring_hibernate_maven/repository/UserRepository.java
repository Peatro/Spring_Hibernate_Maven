package com.example.spring_hibernate_maven.repository;

import com.example.spring_hibernate_maven.entity.UserModel;

import java.util.List;

public interface UserRepository {
    UserModel save(UserModel userModel);

    UserModel findById(Long id);

    List<UserModel> findAll();

    UserModel update(UserModel userModel);

    void deleteById(Long id);
}
