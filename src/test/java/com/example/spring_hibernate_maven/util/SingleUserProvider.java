package com.example.spring_hibernate_maven.util;

import com.example.spring_hibernate_maven.entity.Admin;
import com.example.spring_hibernate_maven.entity.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class SingleUserProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(User.builder()
                        .name("Peter")
                        .email("Peter@gmail.com")
                        .age(18)
                        .build()),
                Arguments.of(Admin.builder()
                        .name("John")
                        .email("JohnAdmin@gmail.com")
                        .root(true)
                        .build())
        );
    }
}
