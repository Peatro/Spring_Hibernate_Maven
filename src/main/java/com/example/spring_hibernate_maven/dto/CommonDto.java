package com.example.spring_hibernate_maven.dto;

import com.example.spring_hibernate_maven.entity.UserModel;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class CommonDto<T extends UserModel> implements Dto<T> {
    protected String name;
    protected String email;

    @Override
    public void convertToDTO(T entity) {
        this.name = entity.getName();
        this.email = entity.getEmail();
    }

    protected void fillCommonFields(T entity) {
        entity.setName(this.name);
        entity.setEmail(this.email);
    }


}
