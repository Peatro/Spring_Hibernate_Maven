package com.example.spring_hibernate_maven.mapper;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public UserMapper userMapper() {
        return Mappers.getMapper(UserMapper.class);
    }

    @Bean
    public AdminMapper adminMapper() {
        return Mappers.getMapper(AdminMapper.class);
    }
}
