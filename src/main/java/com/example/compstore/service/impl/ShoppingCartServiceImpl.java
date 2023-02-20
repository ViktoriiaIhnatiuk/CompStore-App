package com.example.compstore.service.impl;

import com.example.compstore.model.Item;
import com.example.compstore.model.ShoppingCart;
import com.example.compstore.model.User;
import com.example.compstore.repository.ShoppingCartRepository;
import com.example.compstore.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public ShoppingCart createShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart addItemToShoppingCart(User user, Item item) {
        ShoppingCart shoppingCart = getShoppingCartByUser(user);
        shoppingCart.getItems().add(item);
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public String clear(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
        return "Your shopping cart is empty";
    }

    @Override
    public ShoppingCart getShoppingCartByUser(User user) {
        return shoppingCartRepository.findByUser(user);
    }
}
