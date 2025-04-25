package com.example.spring_hibernate_maven.rest;

import com.example.spring_hibernate_maven.dto.AdminDto;
import com.example.spring_hibernate_maven.dto.Dto;
import com.example.spring_hibernate_maven.dto.factory.DtoFactory;
import com.example.spring_hibernate_maven.dto.UserDto;
import com.example.spring_hibernate_maven.entity.Admin;
import com.example.spring_hibernate_maven.entity.User;
import com.example.spring_hibernate_maven.entity.UserModel;
import com.example.spring_hibernate_maven.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/table")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final DtoFactory dtoFactory;

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody UserDto userDTO) {
        return ResponseEntity.ok(userService.save(userDTO.convertToEntity()));
    }

    @PostMapping("/admins")
    public ResponseEntity<UserModel> saveAdmin(@RequestBody AdminDto adminDTO) {
        return ResponseEntity.ok(userService.save(adminDTO.convertToEntity()));
    }

    //DONE
    @GetMapping("/{id}")
    public ResponseEntity<Dto<?>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoFactory.createDto(userService.findById(id)));
    }

    //DONE
    @GetMapping
    public ResponseEntity<List<Dto<?>>> findAll() {
        List<Dto<?>> userDtos = new ArrayList<>();
        List<UserModel> foundUsers = userService.findAll();
        for (UserModel userModel : foundUsers) {
            Dto<?> dto = dtoFactory.createDto(userModel);
            userDtos.add(dto);
        }

        return ResponseEntity.ok(userDtos);
    }

    @PutMapping
    public ResponseEntity<UserModel> update(@RequestBody UserModel userModel) {
        return ResponseEntity.ok(userService.update(userModel));
    }


    //DONE
    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
