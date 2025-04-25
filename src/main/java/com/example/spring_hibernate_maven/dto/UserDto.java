package com.example.spring_hibernate_maven.dto;

import com.example.spring_hibernate_maven.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class UserDto extends CommonDto<User> {
    private int age;

    @Override
    public User convertToEntity() {
        User user = new User();
        fillCommonFields(user);
        user.setAge(this.age);
        return user;
    }

    @Override
    public void convertToDTO(User entity) {
        super.convertToDTO(entity);
        this.age = entity.getAge();
    }
}
