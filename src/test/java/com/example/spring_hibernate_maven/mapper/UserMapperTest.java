package com.example.spring_hibernate_maven.mapper;

import com.example.spring_hibernate_maven.dto.AdminDto;
import com.example.spring_hibernate_maven.dto.UserDto;
import com.example.spring_hibernate_maven.entity.Admin;
import com.example.spring_hibernate_maven.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;

    @Test
    void testUserToUserDto() {
        User user = User.builder()
                .name("John")
                .email("john@example.com")
                .age(25)
                .build();
        UserDto userDto = userMapper.toDto(user);
        assertEquals(user.getName(), userDto.getName());
    }

    @Test
    void testUserDtoToUser() {
        UserDto userDto = new UserDto();
        userDto.setName("John");
        userDto.setEmail("john@example.com");
        userDto.setAge(25);

        User user = userMapper.toEntity(userDto);
        assertEquals(user.getName(), userDto.getName());
    }

    @Test
    void testAdminToAdminDto() {
        Admin admin = Admin.builder()
                .name("Admin")
                .email("admin@example.com")
                .root(true)
                .build();
        AdminDto adminDto = adminMapper.toDto(admin);
        assertEquals(admin.getName(), adminDto.getName());
    }

    @Test
    void testAdminDtoToAdmin() {
        AdminDto adminDto = new AdminDto();
        adminDto.setName("Admin");
        adminDto.setEmail("admin@example.com");
        adminDto.setRoot(true);

        Admin admin = adminMapper.toEntity(adminDto);
        assertEquals(admin.getName(), adminDto.getName());
    }
}
