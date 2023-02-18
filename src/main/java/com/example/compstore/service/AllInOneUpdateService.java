package com.example.compstore.service;

import com.example.compstore.model.AllInOne;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AllInOneUpdateService extends MapstructUpdateService<AllInOne> {
}
