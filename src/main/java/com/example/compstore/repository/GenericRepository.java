package com.example.compstore.repository;

import com.example.compstore.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends Item> extends
        JpaRepository<T, Long> {
}
