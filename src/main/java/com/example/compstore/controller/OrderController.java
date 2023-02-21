package com.example.compstore.controller;

import com.example.compstore.dto.request.OrderRequestDto;
import com.example.compstore.dto.response.OrderResponseDto;
import com.example.compstore.mapper.OrderMapper;
import com.example.compstore.model.User;
import com.example.compstore.service.OrderService;
import com.example.compstore.service.ShoppingCartService;
import com.example.compstore.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderMapper orderMapper;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public OrderController(OrderMapper orderMapper,
                           OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           UserService userService) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping
    @ApiOperation(value = "creates a new order. Available for authenticated users with ADMIN authority only. " +
            "Returns a newly-created order DTO")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return orderMapper.mapToDto(orderService.createOrder(orderMapper.mapToModel(orderRequestDto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN, ROLE_USER')")
    @GetMapping
    @ApiOperation("returns all orders of currently authenticated user for user authority " +
            "and all orders for admin authority")
    public List<OrderResponseDto> getAllOrders() {
        return orderService.getAllOrders().stream()
                .map(orderMapper:: mapToDto)
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN, ROLE_USER')")
    @GetMapping("/{id}")
    @ApiOperation("returns the order with concrete id for admin authority in any case " +
            "and for user authority in case of order belongs to current authenticated user")
    public OrderResponseDto getOrderById(@PathVariable Long id) {
        return orderMapper.mapToDto(orderService.getOrderById(id));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    @ApiOperation("Soft deletion of order with concrete id by marking deleted field as true")
    public String deleteOrderById(@PathVariable Long id) {
        return orderService.deleteOrderById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping("/complete")
    @ApiOperation("creates new order and clears the shopping cart for current authenticated user only")
    public String completeOrder() {
        User user = userService.getCurrentAuthenticatedUser();
        return orderService.completeOrder(shoppingCartService.getShoppingCartByUser(user));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/{id}/accept")
    @ApiOperation("sets order's status as accepted")
    public String acceptOrder(@PathVariable Long id) {
        return orderService.acceptOrder(orderService.getOrderById(id));
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping("/{id}/pay")
    @ApiOperation("sets order's status as paid")
    public String payForOrder(@PathVariable Long id) {
        orderService.payForOrder(orderService.getOrderById(id));
        return "Order has been paid";
    }
}
