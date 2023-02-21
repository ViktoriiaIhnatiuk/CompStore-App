package com.example.compstore.service;

import com.example.compstore.model.Laptop;
import com.example.compstore.model.ShoppingCart;
import com.example.compstore.model.User;

public interface LaptopService extends GenericService<Laptop>{
    ShoppingCart buy(User user, Laptop laptop);
}
