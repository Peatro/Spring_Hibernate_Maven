package com.example.spring_hibernate_maven.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;
import com.example.spring_hibernate_maven.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements ServiceModel {
    @Delegate
    private final UserRepository userRepository;
}
