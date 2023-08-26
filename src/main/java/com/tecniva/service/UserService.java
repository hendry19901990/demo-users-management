package com.tecniva.service;

import com.tecniva.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers(int page, int size, String sortBy);

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}