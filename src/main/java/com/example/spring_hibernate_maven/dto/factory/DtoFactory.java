package com.example.spring_hibernate_maven.dto.factory;

import com.example.spring_hibernate_maven.dto.AdminDto;
import com.example.spring_hibernate_maven.dto.Dto;
import com.example.spring_hibernate_maven.dto.UserDto;
import com.example.spring_hibernate_maven.entity.Admin;
import com.example.spring_hibernate_maven.entity.User;
import com.example.spring_hibernate_maven.entity.UserEntity;
import com.example.spring_hibernate_maven.entity.UserModel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Component
public class DtoFactory {
    private static final Map<Class<? extends UserModel>, Supplier<? extends Dto<?>>> dtoSuppliers = new HashMap<>();

    static {
        registerDto(User.class, UserDto::new);
        registerDto(Admin.class, AdminDto::new);
    }

   public static  <T extends UserEntity> void registerDto(
           Class<T> entityClass, Supplier<? extends Dto<T>> dtoSupplier
   ) {
       dtoSuppliers.put(entityClass, dtoSupplier);
   }

    @SuppressWarnings("unchecked")
    public <T extends UserModel> Dto<T> createDto(T userEntity) {

        Supplier<Dto<T>> supplier = (Supplier<Dto<T>>) dtoSuppliers.get(userEntity.getClass());

        if (supplier == null) {
            throw new IllegalArgumentException("No such entity: " + userEntity.getClass().getName());
        }

        Dto<T> dto = supplier.get();
        dto.convertToDTO(userEntity);
        System.out.println("Created DTO: " + dto.getClass());
        return dto;
    }
}
