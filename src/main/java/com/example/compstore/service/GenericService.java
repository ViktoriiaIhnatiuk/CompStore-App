package com.example.compstore.service;

import com.example.compstore.model.Item;
import java.util.List;

public interface GenericService<T extends Item> {
    T create(T model);

    T get(Long modelId) throws Throwable;

    List<T> getAll();

    T update(Long modelId, T model);

    T delete(Long modelId) throws Throwable;
}
