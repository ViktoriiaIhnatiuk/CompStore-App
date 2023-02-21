package com.example.compstore.mapper;

import com.example.compstore.dto.request.ShoppingCartRequestDto;
import com.example.compstore.dto.response.ShoppingCartResponseDto;
import com.example.compstore.model.ShoppingCart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoppingCartMapper extends RequestMapper<ShoppingCartRequestDto, ShoppingCart>,
        ResponseMapper<ShoppingCart, ShoppingCartResponseDto> {
}
