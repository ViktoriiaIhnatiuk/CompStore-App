package com.example.compstore.service;

import com.example.compstore.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long userId);

    User updateUserById(Long userId, User user);

    User deactivateUserById(Long userId);

    User activateUserById(Long userId);

    User getUserByEmail(String email);

    String getUserEmail();

    Boolean hasAdminRole(User user);

    User getCurrentAuthenticatedUser();
}
