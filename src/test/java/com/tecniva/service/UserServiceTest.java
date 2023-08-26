package com.tecniva.service;

import com.tecniva.model.User;
import com.tecniva.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Example;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "John", "Doe", "john.doe@example.com", new Date()));
        userList.add(new User(2L, "Jane", "Smith", "jane.smith@example.com", new Date()));

        when(userRepository.findAll(Example.of(new User()))).thenReturn(userList);

        List<User> result = userService.getAllUsers(0, 10, "id");

        assertEquals(userList.size(), result.size());
    }

}