package com.example.compstore.service;

import com.example.compstore.model.Item;
import com.example.compstore.model.ShoppingCart;
import com.example.compstore.model.User;

public interface ShoppingCartService {
    ShoppingCart createShoppingCart(User user);
    ShoppingCart addItemToShoppingCart(User user, Item item);
    String clear(ShoppingCart shoppingCart);
    ShoppingCart getShoppingCartByUser(User user);
}
