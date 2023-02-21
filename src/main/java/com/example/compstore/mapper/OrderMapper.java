package com.example.compstore.mapper;

import com.example.compstore.dto.request.OrderRequestDto;
import com.example.compstore.dto.response.OrderResponseDto;
import com.example.compstore.model.Order;
import com.example.compstore.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements RequestMapper<OrderRequestDto, Order>,
ResponseMapper<Order, OrderResponseDto>{
    private final UserService userService;
    private final UserMapper userMapper;

    public OrderMapper(UserService userService,
                       UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public Order mapToModel(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        if (orderRequestDto.getUserId() != null) {
            order.setUser(userService.getUserById(orderRequestDto.getUserId()));
        }
        order.setOrderDate(orderRequestDto.getOrderDate());

        if (orderRequestDto.getItems() != null) {
            order.setItems(orderRequestDto.getItems());
        }
        order.setTotalPrice(orderRequestDto.getTotalPrice());
        order.setFinishDate(orderRequestDto.getFinishDate());
        order.setStatus(orderRequestDto.getStatus());
        order.setDeleted(orderRequestDto.isDeleted());
        return order;
    }

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setUserResponseDto(userMapper.mapToDto(order.getUser()));
        orderResponseDto.setItems(order.getItems());
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setStatus(order.getStatus());
        orderResponseDto.setTotalPrice(order.getTotalPrice());
        orderResponseDto.setFinishDate(order.getFinishDate());
        orderResponseDto.setStatus(order.getStatus());
        orderResponseDto.setDeleted(order.isDeleted());
        return orderResponseDto;
    }
}
