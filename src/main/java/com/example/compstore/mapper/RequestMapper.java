package com.example.compstore.mapper;

public interface RequestMapper <D, M>{
    M mapToModel(D dto);
}
