package com.example.compstore.service.impl;

import com.example.compstore.model.Computer;
import com.example.compstore.repository.ComputerRepository;
import com.example.compstore.service.ComputerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {
    private final ComputerRepository computerRepository;

    public ComputerServiceImpl(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }
}
