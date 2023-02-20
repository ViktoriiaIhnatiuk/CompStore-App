package com.example.compstore.service;

import com.example.compstore.exception.AuthenticationException;
import com.example.compstore.model.User;

public interface AuthenticationService {
    User register(String username, String email, String password, boolean isMaster);

    User login(String email, String password) throws AuthenticationException;
}
