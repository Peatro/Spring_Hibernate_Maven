package com.example.spring_hibernate_maven.service;

import com.example.spring_hibernate_maven.entity.UserModel;

import java.util.List;

public interface ServiceModel {
    UserModel save(UserModel userModel);

    UserModel findById(Long id);

    List<UserModel> findAll();

    UserModel update(UserModel userModel);

    void deleteById(Long id);
}
