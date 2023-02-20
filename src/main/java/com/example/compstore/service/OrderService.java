package com.example.compstore.service;

import com.example.compstore.model.Item;
import com.example.compstore.model.Order;
import com.example.compstore.model.ShoppingCart;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(Long orderId);
    Order updateOrderById(Long orderId);
    String deleteOrderById(Long orderId);
    Order addItemToOrder(Long orderId, Item item);
    Order removeItemFromOrder(Long orderId, Item item);
    String completeOrder(ShoppingCart shoppingCart);
    String acceptOrder(Order order);
    Order payForOrder(Order order);
}
