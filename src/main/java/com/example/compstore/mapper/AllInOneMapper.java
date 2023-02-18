package com.example.compstore.mapper;

import com.example.compstore.dto.request.AllInOneRequestDto;
import com.example.compstore.dto.response.AllInOneResponseDto;
import com.example.compstore.model.AllInOne;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AllInOneMapper extends RequestMapper<AllInOneRequestDto, AllInOne>,
        ResponseMapper<AllInOne, AllInOneResponseDto> {
}
