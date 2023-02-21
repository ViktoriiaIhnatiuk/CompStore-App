package com.example.compstore.service.impl;

import com.example.compstore.model.Role;
import com.example.compstore.model.User;
import com.example.compstore.repository.UserRepository;
import com.example.compstore.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder encoder,
                           UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("Can't find user by id " + userId));
    }

    @Override
    public User updateUserById(Long userId, User user) {
        User userToUpdate = getUserById(userId);
        if (user.getName() != null) {
            userToUpdate.setName(user.getName());
        }
        if (user.getEmail() != null) {
            userToUpdate.setEmail(user.getEmail());
        }
        if (user.getPassword() != null) {
            userToUpdate.setPassword(user.getPassword());
        }
        return createUser(userToUpdate);
    }

    @Override
    public User deactivateUserById(Long userId) {
        User userToDeactivate = getUserById(userId);
        userToDeactivate.setDeactivated(true);
        return createUser(userToDeactivate);
    }

    @Override
    public User activateUserById(Long userId) {
        User userToActivate = getUserById(userId);
        userToActivate.setDeactivated(false);
        return createUser(userToActivate);
    }
    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(
                () -> new RuntimeException("Can`t find user by email " + email));
    }

    @Override
    public String getUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }

    @Override
    public Boolean hasAdminRole(User user) {
        return user.getRoles().stream()
                .anyMatch(e -> e.equals(Role.ADMIN));
    }

    @Override
    public User getCurrentAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return getUserByEmail(userDetails.getUsername());
    }
}
