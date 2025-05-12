package com.example.spring_hibernate_maven.mapper;

import com.example.spring_hibernate_maven.dto.AdminDto;
import com.example.spring_hibernate_maven.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper extends GenericMapper<Admin, AdminDto> {
}
