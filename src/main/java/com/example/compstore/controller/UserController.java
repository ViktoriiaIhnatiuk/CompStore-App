package com.example.compstore.controller;

import com.example.compstore.dto.request.UserRequestDto;
import com.example.compstore.dto.response.UserResponseDto;
import com.example.compstore.mapper.UserMapper;
import com.example.compstore.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService,
                          UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }


    @PostMapping
    @ApiOperation("inserts a new user into DB")
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userMapper.mapToDto(userService.createUser(
              userMapper.mapToModel(userRequestDto)));
    }

    @GetMapping("/{id}")
    @ApiOperation("returns the user with the concrete id")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userMapper.mapToDto(userService.getUserById(id));
    }

    @GetMapping
    @ApiOperation("returns all users from DB")
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(userMapper:: mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @ApiOperation("updates a user with concrete id. partial updating is available")
    public UserResponseDto updateUserById(@PathVariable Long id,
                                          @RequestBody UserRequestDto userRequestDto) {
        return userMapper.mapToDto(userService.updateUserById(id,
                userMapper.mapToModel(userRequestDto)));
    }

    @GetMapping("/{id}/deactivate")
    @ApiOperation("marks user as deactivated")
    public UserResponseDto deactivateUserById(@PathVariable Long id) {
        return userMapper.mapToDto(userService.deactivateUserById(id));
    }

    @GetMapping("/{id}/activate")
    @ApiOperation("marks user's deactivated field as false")
    public UserResponseDto activateUserById(@PathVariable Long id) {
        return userMapper.mapToDto(userService.activateUserById(id));
    }
}
