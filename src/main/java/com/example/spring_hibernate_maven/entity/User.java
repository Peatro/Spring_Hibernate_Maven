package com.example.spring_hibernate_maven.entity;

import lombok.*;
import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("USER")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends UserEntity {

    @Column
    private int age;
}
