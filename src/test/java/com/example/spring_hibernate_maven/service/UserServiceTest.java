package com.example.spring_hibernate_maven.service;

import com.example.spring_hibernate_maven.entity.UserModel;
import com.example.spring_hibernate_maven.repository.UserRepository;
import com.example.spring_hibernate_maven.util.ListOfUsersProvider;
import com.example.spring_hibernate_maven.util.SingleUserProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UserService userService;

    @ParameterizedTest
    @ArgumentsSource(SingleUserProvider.class)
    void saveUser(UserModel user) {
        when(userRepositoryMock.save(user)).thenReturn(user);
        assertEquals(user, userService.save(user));
        verify(userRepositoryMock, times(1)).save(user);
    }

    @ParameterizedTest
    @ArgumentsSource(SingleUserProvider.class)
    void findById_ExistingUser_ShouldReturnUser(UserModel user) {
        Long id = 1L;

        when(userRepositoryMock.findById(id)).thenReturn(user);
        assertEquals(user, userService.findById(id));
        verify(userRepositoryMock, times(1)).findById(id);
    }

    @Test
    void findById_NonExistentId_ShouldReturnNull() {
        Long nonExistentId = 999L;
        when(userRepositoryMock.findById(nonExistentId)).thenReturn(null);

        assertNull(userService.findById(nonExistentId));
        verify(userRepositoryMock, times(1)).findById(nonExistentId);
    }

    @ParameterizedTest
    @ArgumentsSource(ListOfUsersProvider.class)
    void findAll(List<UserModel> users) {
        when(userRepositoryMock.findAll()).thenReturn(users);
        assertEquals(users, userService.findAll());
        verify(userRepositoryMock).findAll();
    }

    @ParameterizedTest
    @ArgumentsSource(SingleUserProvider.class)
    void update(UserModel user) {
        when(userRepositoryMock.update(user)).thenReturn(user);
        assertEquals(user, userService.update(user));
        verify(userRepositoryMock).update(user);
    }

    @Test
    void deleteById_ShouldCallRepositoryDelete() {
        Long id = 1L;
        userService.deleteById(id);
        verify(userRepositoryMock).deleteById(id);
    }

    @Test
    void deleteById_NonExistentId_ShouldNotThrowException() {
        Long nonExistentId = 999L;
        userService.deleteById(nonExistentId);
        verify(userRepositoryMock, times(1)).deleteById(nonExistentId);
    }
}
