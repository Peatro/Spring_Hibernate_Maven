package com.example.spring_hibernate_maven.dto;

import com.example.spring_hibernate_maven.entity.Admin;
import com.example.spring_hibernate_maven.entity.User;
import com.example.spring_hibernate_maven.entity.UserModel;
import com.example.spring_hibernate_maven.mapper.AdminMapper;
import com.example.spring_hibernate_maven.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DtoEntityFactory {
    private final UserMapper userMapper;
    private final AdminMapper adminMapper;

    public Dto createDto(UserModel userModel) {
        if (userModel.getClass() == User.class) {
            return userMapper.toDto((User) userModel);
        } else if (userModel.getClass() == Admin.class) {
            return adminMapper.toDto((Admin) userModel);
        }
        return null;
    }

    public UserModel createUserModel(Dto dto) {
        if (dto.getClass() == UserDto.class) {
            return userMapper.toEntity((UserDto) dto);
        } else if (dto.getClass() == AdminDto.class) {
            return adminMapper.toEntity((AdminDto) dto);
        }
        return null;
    }
}
