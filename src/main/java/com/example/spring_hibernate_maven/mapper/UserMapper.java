package com.example.spring_hibernate_maven.mapper;

import com.example.spring_hibernate_maven.dto.UserDto;
import com.example.spring_hibernate_maven.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserDto> {

}
