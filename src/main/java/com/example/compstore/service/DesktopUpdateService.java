package com.example.compstore.service;

import com.example.compstore.model.Desktop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DesktopUpdateService extends MapstructUpdateService<Desktop> {
}
