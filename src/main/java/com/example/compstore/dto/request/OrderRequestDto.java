package com.example.compstore.dto.request;

import com.example.compstore.model.Item;
import com.example.compstore.model.Status;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderRequestDto {
    private Long userId;
    private LocalDateTime orderDate;
    private List<Item> items;
    private BigDecimal totalPrice = BigDecimal.ZERO;
    private LocalDateTime finishDate;
    private Status status;
    private boolean deleted;

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
