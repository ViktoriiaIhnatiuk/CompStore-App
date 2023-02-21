package com.example.compstore.service;

import com.example.compstore.model.Desktop;
import com.example.compstore.model.ShoppingCart;
import com.example.compstore.model.User;

public interface DesktopService extends GenericService<Desktop> {
    ShoppingCart buy(User user, Desktop desktop);
}
