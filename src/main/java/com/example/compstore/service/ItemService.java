package com.example.compstore.service;

import com.example.compstore.model.Item;
import com.example.compstore.model.ShoppingCart;
import com.example.compstore.model.User;

public interface ItemService extends GenericService<Item>{
    ShoppingCart addItemToShoppingCart(User user, Item item);
}
