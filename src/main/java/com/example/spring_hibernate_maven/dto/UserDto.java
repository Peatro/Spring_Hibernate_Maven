package com.example.spring_hibernate_maven.dto;

import com.example.spring_hibernate_maven.entity.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class UserDto extends CommonDto {
    private int age;
}
