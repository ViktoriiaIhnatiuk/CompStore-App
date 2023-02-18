package com.example.compstore.mapper;

import com.example.compstore.dto.request.DesktopRequestDto;
import com.example.compstore.dto.response.DesktopResponseDto;
import com.example.compstore.model.Desktop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DesktopMapper extends RequestMapper<DesktopRequestDto, Desktop>,
        ResponseMapper<Desktop, DesktopResponseDto> {

}
