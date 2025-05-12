package com.example.spring_hibernate_maven.dto;

import com.example.spring_hibernate_maven.entity.UserModel;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class CommonDto implements Dto {
    protected String name;
    protected String email;
}
