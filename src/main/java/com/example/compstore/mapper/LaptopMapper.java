package com.example.compstore.mapper;

import com.example.compstore.dto.request.LaptopRequestDto;
import com.example.compstore.dto.response.LaptopResponseDto;
import com.example.compstore.model.Laptop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LaptopMapper extends RequestMapper<LaptopRequestDto, Laptop>,
        ResponseMapper<Laptop, LaptopResponseDto> {
}
