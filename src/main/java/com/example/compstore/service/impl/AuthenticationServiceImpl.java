package com.example.compstore.service.impl;

import com.example.compstore.exception.AuthenticationException;
import com.example.compstore.model.Role;
import com.example.compstore.model.Status;
import com.example.compstore.model.User;
import com.example.compstore.repository.UserRepository;
import com.example.compstore.service.AuthenticationService;
import com.example.compstore.service.ShoppingCartService;
import com.example.compstore.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String USER_ROLE = Status.ACCEPTED.name();
    private static final String projectStatus = Status.PROJECT.name();
    private static final String doneStatus = Status.DONE.name();
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final ShoppingCartService shoppingCartService;

    public AuthenticationServiceImpl(UserService userService,
                                     PasswordEncoder passwordEncoder,
                                     UserRepository userRepository,
                                     ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.shoppingCartService = shoppingCartService;
    }

    @Transactional
    @Override
    public User register(String username, String email, String password, boolean isMaster) {
        User user = new User();
        user.setName(username);
        user.setEmail(email);
        user.setPassword(password);
            user.setRoles(Set.of(Role.USER));
            User createdUser =  userService.createUser(user);
            shoppingCartService.createShoppingCart(createdUser);
        return createdUser;
    }

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new AuthenticationException("Incorrect username or password!"));

        if (user.getEmail().equals(email)
                && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new AuthenticationException("Incorrect username or password!");
        }
    }
}
