package com.example.spring_hibernate_maven.entity;

public interface UserModel {
    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    String getEmail();

    void setEmail(String email);
}
