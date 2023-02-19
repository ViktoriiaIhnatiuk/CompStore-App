package com.example.compstore.controller;

import com.example.compstore.model.Item;
import com.example.compstore.service.ItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    @ApiOperation("returns all items from DB")
    public List<Item> findAll() {
        return itemService.getAllItems();
    }
}
