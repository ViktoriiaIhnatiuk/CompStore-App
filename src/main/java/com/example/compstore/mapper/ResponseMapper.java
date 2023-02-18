package com.example.compstore.mapper;

public interface ResponseMapper <M, D>{
    D mapToDto(M model);
}
