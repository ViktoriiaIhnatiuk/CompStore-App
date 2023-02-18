package com.example.compstore.service;

import com.example.compstore.model.Laptop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LaptopUpdateService extends MapstructUpdateService<Laptop> {
}
