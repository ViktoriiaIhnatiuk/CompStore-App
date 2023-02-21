package com.example.compstore.controller;

import com.example.compstore.dto.request.AllInOneRequestDto;
import com.example.compstore.dto.response.AllInOneResponseDto;
import com.example.compstore.dto.response.ShoppingCartResponseDto;
import com.example.compstore.mapper.AllInOneMapper;
import com.example.compstore.mapper.ShoppingCartMapper;
import com.example.compstore.model.AllInOne;
import com.example.compstore.model.User;
import com.example.compstore.service.AllInOneService;
import com.example.compstore.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/all-in-one")
public class AllInOneController {
    private final AllInOneService allInOneService;
    private final AllInOneMapper allInOneMapper;
    private final UserService userService;
    private final ShoppingCartMapper shoppingCartMapper;

    public AllInOneController(AllInOneService allInOneService,
                              AllInOneMapper allInOneMapper, UserService userService, ShoppingCartMapper shoppingCartMapper) {
        this.allInOneService = allInOneService;
        this.allInOneMapper = allInOneMapper;
        this.userService = userService;
        this.shoppingCartMapper = shoppingCartMapper;
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    @ApiOperation("inserts a new all-in-one into DB")
    public AllInOneResponseDto createAllInOne(@Valid @RequestBody AllInOneRequestDto allInOneRequestDto) {
        return allInOneMapper.mapToDto(allInOneService.create(allInOneMapper.mapToModel(allInOneRequestDto)));
    }

    @GetMapping
    @ApiOperation("returns all all-in-one from DB")
    public List<AllInOneResponseDto> getAllAllInOne() {
        return allInOneService.getAll().stream()
                .map(allInOneMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation("returns the all-in-one with the concrete id from DB")
    public AllInOneResponseDto getAllInOneById(@PathVariable Long id) throws Throwable {
        return allInOneMapper.mapToDto(allInOneService.get(id));
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/{id}")
    @ApiOperation("updates the all-in-one with the concrete id. Partial updating is available")
    public AllInOneResponseDto updateLaptopById(@PathVariable Long id,
                                   @Valid @RequestBody AllInOneRequestDto allInOneRequestDto) {
        return allInOneMapper.mapToDto(allInOneService.update(id,
                allInOneMapper.mapToModel(allInOneRequestDto)));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}/delete")
    @ApiOperation("soft deletion. marks deleted field of all-in-one with a concrete id as true")
    public AllInOneResponseDto deleteAllInOneById(@PathVariable Long id) throws Throwable {
        return allInOneMapper.mapToDto(allInOneService.delete(id));
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping("/{id}/buy")
    @ApiOperation("adds all-in-one with a concrete id to the current authenticated user's " +
            "shopping cart")
    public ShoppingCartResponseDto buyAllInOne(@PathVariable Long id) throws Throwable {
        User user = userService.getCurrentAuthenticatedUser();
        AllInOne allInOne = allInOneService.get(id);
        return shoppingCartMapper.mapToDto(allInOneService.buy(user, allInOne));
    }
}
