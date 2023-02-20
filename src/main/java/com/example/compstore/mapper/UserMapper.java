package com.example.compstore.mapper;

import com.example.compstore.dto.request.UserRequestDto;
import com.example.compstore.dto.response.UserResponseDto;
import com.example.compstore.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends RequestMapper<UserRequestDto, User>,
        ResponseMapper<User, UserResponseDto> {
}
