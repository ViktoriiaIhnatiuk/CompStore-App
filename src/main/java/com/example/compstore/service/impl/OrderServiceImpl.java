package com.example.compstore.service.impl;

import com.example.compstore.model.*;
import com.example.compstore.repository.OrderRepository;
import com.example.compstore.service.OrderService;
import com.example.compstore.service.ShoppingCartService;
import com.example.compstore.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private static final String ACCEPTED_STATUS = Status.ACCEPTED.name();
    private static final String PROJECT_STATUS = Status.PROJECT.name();
    private static final String DONE_STATUS = Status.DONE.name();
    private static final String PAID_FOR_STATUS = Status.PAID_FOR.name();
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ShoppingCartService shoppingCartService,
                            UserService userService) {
        this.orderRepository = orderRepository;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }
    @Transactional
    @Override
    public Order createOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(Status.PROJECT);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        User user = userService.getCurrentAuthenticatedUser();
        if (userService.hasAdminRole(user)) {
            return orderRepository.findAll();
        }
        return orderRepository.getAllOrdersByUserEmail(user.getEmail());
    }

    @Override
    public Order getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new RuntimeException("Can't find order with id " + orderId));
        User user = userService.getCurrentAuthenticatedUser();
        if (userService.hasAdminRole(user) || order.getUser().equals(user)) {
        return order;
        }
        throw new RuntimeException("please, enter correct order id");
    }

    @Override
    public Order updateOrderById(Long orderId) {
        return null;
    }

    @Override
    public String deleteOrderById(Long orderId) {
        Order orderToDelete = getOrderById(orderId);
        orderToDelete.setDeleted(true);
        orderRepository.save(orderToDelete);
        return "Order with id " + orderId + " has been deleted successfully";
    }

    @Transactional
    @Override
    public String completeOrder(ShoppingCart shoppingCart) {
        List<Item> items = shoppingCart.getItems();
        if(items.size() != 0) {
            Order order = new Order();
            User user = userService.getUserById(shoppingCart.getId());
            BigDecimal orderPrice = items.stream().map(Item::getPrice).reduce(BigDecimal::add).get();
            order.setItems(items);
            order.setTotalPrice(orderPrice);
            order.setUser(user);
            order.setOrderDate(LocalDateTime.now());
            order.setStatus(Status.valueOf(PROJECT_STATUS));
            createOrder(order);
            shoppingCartService.clear(shoppingCart);
            return "Order has been completed successfully";
        }
        return "Your shopping cart is empty";
    }


    public String acceptOrder(Order order) {
        if (order.getStatus().name().equals(PROJECT_STATUS)) {
            order.setStatus(Status.valueOf(ACCEPTED_STATUS));
            orderRepository.save(order);
        }
        return "Order has been accepted";
    }

    @Override
    public Order payForOrder(Order order) {
        User user = order.getUser();
        order.setStatus(Status.valueOf(PAID_FOR_STATUS));
        return orderRepository.save(order);
    }

    @Override
    public Order finishOrder(Order order) {
        order.setStatus(Status.valueOf(DONE_STATUS));
        return orderRepository.save(order);
    }
}
