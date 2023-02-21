package com.example.compstore.controller;

import com.example.compstore.dto.response.AllInOneResponseDto;
import com.example.compstore.dto.response.DesktopResponseDto;
import com.example.compstore.dto.response.LaptopResponseDto;
import com.example.compstore.dto.response.ShoppingCartResponseDto;
import com.example.compstore.mapper.AllInOneMapper;
import com.example.compstore.mapper.DesktopMapper;
import com.example.compstore.mapper.LaptopMapper;
import com.example.compstore.mapper.ShoppingCartMapper;
import com.example.compstore.model.*;
import com.example.compstore.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    private final LaptopService laptopService;
    private final DesktopService desktopService;
    private final AllInOneService allInOneService;
    private final DesktopMapper desktopMapper;
    private final LaptopMapper laptopMapper;
    private final AllInOneMapper allInOneMapper;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper shoppingCartMapper;

    public ItemController(ItemService itemService,
                          LaptopService laptopService,
                          DesktopService desktopService,
                          AllInOneService allInOneService,
                          DesktopMapper desktopMapper,
                          LaptopMapper laptopMapper,
                          AllInOneMapper allInOneMapper,
                          UserService userService,
                          ShoppingCartService shoppingCartService,
                          ShoppingCartMapper shoppingCartMapper) {
        this.itemService = itemService;
        this.laptopService = laptopService;
        this.desktopService = desktopService;
        this.allInOneService = allInOneService;
        this.desktopMapper = desktopMapper;
        this.laptopMapper = laptopMapper;
        this.allInOneMapper = allInOneMapper;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @GetMapping
    @ApiOperation("returns all items from DB")
    public List<Object> findAll() {
        return itemService.getAll().stream()
                .map(e -> e.getClass().equals(Laptop.class) ?
                        laptopMapper.mapToDto((Laptop) e) :
                        e.getClass().equals(Desktop.class) ?
                        desktopMapper.mapToDto((Desktop) e) :
                        allInOneMapper.mapToDto((AllInOne) e))
                        .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation("returns the item with concrete id from DB")
    public Item findById(@PathVariable Long id) throws Throwable {
        return itemService.get(id);
    }

    @GetMapping("/{id}/delete")
    @ApiOperation("provides safe deleting of item with concrete id from DB "
    + " by setting true value into '\"'deleted'\" ' field")
    public Item deleteById(@PathVariable Long id) throws Throwable {
        return itemService.delete(id);
    }
}
