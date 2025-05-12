package com.example.spring_hibernate_maven;

import com.example.spring_hibernate_maven.rest.UserRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})

@EnableTransactionManagement
public class SpringHibernateMavenApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringHibernateMavenApplication.class, args);

        UserRestController userRestController = context.getBean(UserRestController.class);
    }
}