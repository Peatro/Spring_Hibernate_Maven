package com.example.spring_hibernate_maven.rest;

import com.example.spring_hibernate_maven.dto.*;
import com.example.spring_hibernate_maven.entity.UserModel;
import com.example.spring_hibernate_maven.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/table")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final DtoEntityFactory dtoEntityFactory;

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody UserDto userDTO) {
        return ResponseEntity.ok(userService.save(dtoEntityFactory.createUserModel(userDTO)));
    }

    @PostMapping("/admins")
    public ResponseEntity<UserModel> saveAdmin(@RequestBody AdminDto adminDTO) {
        return ResponseEntity.ok(userService.save(dtoEntityFactory.createUserModel(adminDTO)));
    }

    //DONE
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Dto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoEntityFactory.createDto(userService.findById(id)));
    }

    //DONE
    @GetMapping
    public ResponseEntity<List<Dto>> findAll() {
        List<Dto> userDtos = new ArrayList<>();
        List<UserModel> foundUsers = userService.findAll();
        for (UserModel userModel : foundUsers) {
            userDtos.add(dtoEntityFactory.createDto(userModel));
        }

        return ResponseEntity.ok(userDtos);
    }

    @PutMapping
    public ResponseEntity<UserModel> update(@RequestBody CommonDto userDto) {
        return ResponseEntity.ok(userService.update(dtoEntityFactory.createUserModel(userDto)));
    }

    //DONE
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
