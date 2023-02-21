package com.example.compstore.service;

import com.example.compstore.model.AllInOne;
import com.example.compstore.model.ShoppingCart;
import com.example.compstore.model.User;

public interface AllInOneService extends GenericService<AllInOne> {
    ShoppingCart buy(User user, AllInOne allInOne);
}
