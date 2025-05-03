package com.example.spring_hibernate_maven;

import com.example.spring_hibernate_maven.entity.Admin;
import com.example.spring_hibernate_maven.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import com.example.spring_hibernate_maven.service.UserService;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})

@EnableTransactionManagement
public class SpringHibernateMavenApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringHibernateMavenApplication.class, args);

        UserService userService = context.getBean(UserService.class);
        User newUser1 = User.builder()
                .name("Peter")
                .email("peter@example.com")
                .age(25)
                .build();

        Admin admin = Admin.builder()
                .name("John")
                .email("john@admin.com")
                .root(true)
                .build();

        userService.save(newUser1);
        userService.save(admin);
    }
}
