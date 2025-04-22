package com.example.spring_hibernate_maven.repository;

import com.example.spring_hibernate_maven.entity.UserEntity;
import com.example.spring_hibernate_maven.entity.UserModel;
import com.example.spring_hibernate_maven.util.MultipleUsersProvider;
import com.example.spring_hibernate_maven.util.SingleUserProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@EntityScan("com.example.spring_hibernate_maven.entity")
@Import(HibernateUserRepository.class)
@AutoConfigureTestEntityManager
@Transactional
@EnableTransactionManagement
public class HibernateUserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @ParameterizedTest
    @ArgumentsSource(SingleUserProvider.class)
    void findById_ShouldReturnRegularUser(UserModel user) {
        entityManager.persist(user);
        entityManager.flush();
        entityManager.clear();

        UserModel foundUser = userRepository.findById(user.getId());

        assertThat(foundUser).isNotNull();
        assertThat(foundUser).isEqualTo(user);
    }

    @ParameterizedTest
    @ArgumentsSource(SingleUserProvider.class)
    void save_ShouldSaveUser(UserModel user) {
        userRepository.save(user);
        entityManager.flush();
        entityManager.clear();

        UserModel foundUser = entityManager.find(UserEntity.class, user.getId());
        assertThat(foundUser).isNotNull();
        assertThat(foundUser).isEqualTo(user);
    }

    @ParameterizedTest
    @ArgumentsSource(SingleUserProvider.class)
    void update_ShouldUpdateUser(UserModel user) {
        entityManager.persist(user);
        entityManager.flush();
        entityManager.clear();

        user.setEmail("changed@email.com");

        UserModel updatedUser = userRepository.update(user);
        assertThat(updatedUser).isNotNull();
        assertThat(updatedUser.getEmail()).isEqualTo(entityManager.find(UserEntity.class, updatedUser.getId()).getEmail());
    }

    @ParameterizedTest
    @ArgumentsSource(SingleUserProvider.class)
    void delete_ShouldDeleteUser(UserModel user) {
        entityManager.persist(user);
        entityManager.flush();
        entityManager.clear();

        assertThat(entityManager.find(UserEntity.class, user.getId())).isNotNull();

        userRepository.deleteById(user.getId());

        assertThat(entityManager.find(UserEntity.class, user.getId())).isNull();
    }

    @ParameterizedTest
    @ArgumentsSource(MultipleUsersProvider.class)
    void findAll_ShouldReturnAllUsers(UserModel user1, UserModel user2) {
        entityManager.persistAndFlush(user1);
        entityManager.persistAndFlush(user2);

        List<UserModel> expectedUsers = List.of(user1, user2);
        List<UserModel> users = userRepository.findAll();

        assertThat(users).isNotNull();
        assertThat(users).isEqualTo(expectedUsers);
    }
}
