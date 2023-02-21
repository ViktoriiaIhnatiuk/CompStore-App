package com.example.compstore.controller;

import com.example.compstore.dto.request.DesktopRequestDto;
import com.example.compstore.dto.response.DesktopResponseDto;
import com.example.compstore.dto.response.ShoppingCartResponseDto;
import com.example.compstore.mapper.DesktopMapper;
import com.example.compstore.mapper.ShoppingCartMapper;
import com.example.compstore.model.Desktop;
import com.example.compstore.model.User;
import com.example.compstore.service.DesktopService;
import com.example.compstore.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/desktops")
public class DesktopController {
    private final DesktopService desktopService;
    private final DesktopMapper desktopMapper;
    private final UserService userService;
    private final ShoppingCartMapper shoppingCartMapper;

    public DesktopController(DesktopService desktopService,
                             DesktopMapper desktopMapper,
                             UserService userService,
                             ShoppingCartMapper shoppingCartMapper) {
        this.desktopService = desktopService;
        this.desktopMapper = desktopMapper;
        this.userService = userService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    @ApiOperation("inserts a new desktop into DB")
    public DesktopResponseDto createDesktop(@Valid @RequestBody DesktopRequestDto desktopRequestDto) {
        return desktopMapper.mapToDto(desktopService.create(desktopMapper.mapToModel(desktopRequestDto)));
    }

    @GetMapping
    @ApiOperation("returns all desktops from DB")
    public List<DesktopResponseDto> getAllDesktops() {
        return desktopService.getAll().stream()
                .map(desktopMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation("returns the desktop with the concrete id from DB")
    public DesktopResponseDto getDesktopById(@PathVariable Long id) throws Throwable {
        return desktopMapper.mapToDto(desktopService.get(id));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PatchMapping("/{id}")
    @ApiOperation("updates the desktop with the concrete id. partial update is available")
    public DesktopResponseDto updateDesktopById(@PathVariable Long id,
                                   @Valid @RequestBody DesktopRequestDto desktopRequestDto) {
        return desktopMapper.mapToDto(desktopService.update(id,
                desktopMapper.mapToModel(desktopRequestDto)));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PatchMapping("/{id}/delete")
    @ApiOperation("soft deletion. marks deleted field of desktop with a concrete id as true")
    public DesktopResponseDto deleteDesktopById(@PathVariable Long id) throws Throwable {
        return desktopMapper.mapToDto(desktopService.delete(id));
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PatchMapping("/{id}/buy")
    @ApiOperation("adds the desktop with a concrete id to the current authenticated user's " +
            "shopping cart")
    public ShoppingCartResponseDto Buy(@PathVariable Long id)
            throws Throwable {
        User user = userService.getCurrentAuthenticatedUser();
        Desktop desktop = desktopService.get(id);
        return shoppingCartMapper.mapToDto(desktopService.buy(user, desktop));
    }
}
