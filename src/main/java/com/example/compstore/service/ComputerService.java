package com.example.compstore.service;

import com.example.compstore.model.Computer;
import java.util.List;

public interface ComputerService {
    List<Computer> getAllComputers();

    Computer get(Long id);
}
