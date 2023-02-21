package com.example.compstore.controller;

import com.example.compstore.dto.request.UserRequestDto;
import com.example.compstore.dto.response.UserResponseDto;
import com.example.compstore.exception.AuthenticationException;
import com.example.compstore.mapper.UserMapper;
import com.example.compstore.model.User;
import com.example.compstore.security.jwt.JwtTokenProvider;
import com.example.compstore.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(AuthenticationService authService,
                                    UserMapper userMapper,
                                    JwtTokenProvider jwtTokenProvider) {
        this.authService = authService;
        this.userMapper = userMapper;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto userRequestDto) {
        User user = authService.register(userRequestDto.getName(),
                userRequestDto.getEmail(),
                userRequestDto.getPassword());
        return userMapper.mapToDto(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserRequestDto requestDto)
            throws AuthenticationException {
        User user = authService.login(requestDto.getEmail(), requestDto.getPassword());
        String token = jwtTokenProvider.createToken(user.getEmail(),
                user.getRoles().stream()
                .map(e -> e.name())
                .collect(Collectors.toList()));
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}
