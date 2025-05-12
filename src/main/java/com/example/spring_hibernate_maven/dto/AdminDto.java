package com.example.spring_hibernate_maven.dto;

import com.example.spring_hibernate_maven.entity.Admin;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class AdminDto extends CommonDto {;
    private Boolean root;
}
