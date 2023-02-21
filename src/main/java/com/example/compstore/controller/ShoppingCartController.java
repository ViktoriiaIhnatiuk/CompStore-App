package com.example.compstore.controller;

import com.example.compstore.dto.request.IdRequestDto;
import com.example.compstore.dto.response.ShoppingCartResponseDto;
import com.example.compstore.mapper.ShoppingCartMapper;
import com.example.compstore.model.Item;
import com.example.compstore.model.User;
import com.example.compstore.service.ItemService;
import com.example.compstore.service.ShoppingCartService;
import com.example.compstore.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartController(UserService userService,
                                  ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper shoppingCartMapper) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @ApiOperation("returns a shopping cart by cincrete user")
    @GetMapping("/by-user")
    public ShoppingCartResponseDto getShoppingCartByUser() {
        User user = userService.getCurrentAuthenticatedUser();
        return shoppingCartMapper.mapToDto(shoppingCartService.getShoppingCartByUser(user));
    }
}
