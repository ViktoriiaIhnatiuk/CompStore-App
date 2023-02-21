package com.example.compstore.dto.request;

import com.example.compstore.model.Item;

import java.util.List;

public class ShoppingCartRequestDto {
    private Long id;
    private List<Item> items;

    public Long getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }
}
