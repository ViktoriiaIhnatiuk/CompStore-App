package com.example.compstore.controller;

import com.example.compstore.dto.request.UserRequestDto;
import com.example.compstore.dto.response.UserResponseDto;
import com.example.compstore.mapper.RequestMapper;
import com.example.compstore.mapper.ResponseMapper;
import com.example.compstore.model.User;
import com.example.compstore.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RequestMapper<UserRequestDto, User> userRequestMapper;
    private final ResponseMapper<User, UserResponseDto> userResponseMapper;

    public UserController(UserService userService,
                          RequestMapper<UserRequestDto, User> userRequestMapper,
                          ResponseMapper<User, UserResponseDto> userResponseMapper) {
        this.userService = userService;
        this.userRequestMapper = userRequestMapper;
        this.userResponseMapper = userResponseMapper;
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userResponseMapper.mapToDto(userService.createUser(
              userRequestMapper.mapToModel(userRequestDto)));
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userResponseMapper.mapToDto(userService.getUserById(id));
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(userResponseMapper:: mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUserById(@PathVariable Long id,
                                          @RequestBody UserRequestDto userRequestDto) {
        return userResponseMapper.mapToDto(userService.updateUserById(id,
                userRequestMapper.mapToModel(userRequestDto)));
    }

    @DeleteMapping("/{id}")
    public UserResponseDto deleteUserById(@PathVariable Long id) {
        return userResponseMapper.mapToDto(userService.deleteUserById(id));
    }
}
