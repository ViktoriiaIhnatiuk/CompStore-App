package com.example.compstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository<Item> extends
        JpaRepository<com.example.compstore.model.Item, Long> {
}
