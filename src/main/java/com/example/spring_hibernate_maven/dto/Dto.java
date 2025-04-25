package com.example.spring_hibernate_maven.dto;

import com.example.spring_hibernate_maven.entity.UserModel;

public interface Dto<T extends UserModel>  {
    T convertToEntity();
    void convertToDTO(T entity);
}
