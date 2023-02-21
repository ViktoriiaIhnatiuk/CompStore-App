package com.example.compstore.controller;

import com.example.compstore.dto.request.LaptopRequestDto;
import com.example.compstore.dto.response.LaptopResponseDto;
import com.example.compstore.dto.response.ShoppingCartResponseDto;
import com.example.compstore.mapper.LaptopMapper;
import com.example.compstore.mapper.ShoppingCartMapper;
import com.example.compstore.model.Laptop;
import com.example.compstore.model.User;
import com.example.compstore.service.LaptopService;
import com.example.compstore.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
    private final LaptopService laptopService;
    private final LaptopMapper laptopMapper;
    private final UserService userService;
    private final ShoppingCartMapper shoppingCartMapper;

    public LaptopController(LaptopService laptopService,
                            LaptopMapper laptopMapper,
                            UserService userService,
                            ShoppingCartMapper shoppingCartMapper) {
        this.laptopService = laptopService;
        this.laptopMapper = laptopMapper;
        this.userService = userService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    @ApiOperation("inserts a new laptop into DB")
    public LaptopResponseDto createLaptop(@Valid @RequestBody LaptopRequestDto laptopRequestDto) {
        return laptopMapper.mapToDto(laptopService.create(laptopMapper.mapToModel(laptopRequestDto)));
    }

    @GetMapping
    @ApiOperation("returns all laptops from DB")
    public List<LaptopResponseDto> getAllLaptops() {
        return laptopService.getAll().stream()
                .map(laptopMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation("returns the laptop with the concrete id from DB")
    public LaptopResponseDto getLaptopById(@PathVariable Long id) throws Throwable {
        return laptopMapper.mapToDto(laptopService.get(id));
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PatchMapping("/{id}")
    @ApiOperation("updates the laptop with the concrete id. partial updating is available")
    public LaptopResponseDto updateLaptopById(@PathVariable Long id,
                                  @Valid @RequestBody LaptopRequestDto laptopRequestDto) {
        return laptopMapper.mapToDto(laptopService.update(id,
                laptopMapper.mapToModel(laptopRequestDto)));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PatchMapping("/{id}/delete")
    @ApiOperation("soft deletion. marks deleted field of the laptop with the concrete id as true")
    public LaptopResponseDto deleteLaptopById(@PathVariable Long id) throws Throwable {
        return laptopMapper.mapToDto(laptopService.delete(id));
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PatchMapping("/{id}/buy")
    @ApiOperation("adds the laptop with a concrete id to the current authenticated user's " +
            "shopping cart")
    public ShoppingCartResponseDto buy(@PathVariable Long id)
            throws Throwable {
        User user = userService.getCurrentAuthenticatedUser();
        Laptop laptop = laptopService.get(id);
        return shoppingCartMapper.mapToDto(laptopService.buy(user, laptop));
    }
}
