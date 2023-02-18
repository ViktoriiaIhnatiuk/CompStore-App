package com.example.compstore.service.impl;

import com.example.compstore.model.Laptop;
import com.example.compstore.repository.LaptopRepository;
import com.example.compstore.service.LaptopService;
import com.example.compstore.service.LaptopUpdateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService{
    private final LaptopRepository laptopRepository;
    private final LaptopUpdateService laptopUpdateService;


    public LaptopServiceImpl(LaptopRepository laptopRepository,
                             LaptopUpdateService laptopUpdateService) {
        this.laptopRepository = laptopRepository;
        this.laptopUpdateService = laptopUpdateService;
    }

    @Override
    public Laptop create(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @Override
    public Laptop get(Long laptopId) {
        return laptopRepository.findById(laptopId).orElseThrow(
                () -> new RuntimeException("Can't find laptop by id: " + laptopId)
        );
    }

    @Override
    public List<Laptop> getAll() {
        return laptopRepository.findAll();
    }

    @Override
    public Laptop update(Long laptopId, Laptop laptop) {
        Laptop laptopToUpdate = get(laptopId);
        laptopUpdateService.updateModel(laptop, laptopToUpdate);
        return laptopRepository.save(laptopToUpdate);
    }

    @Override
    public Laptop delete(Long laptopId) {
        Laptop laptopToDelete = get(laptopId);
        laptopRepository.delete(laptopToDelete);
        return laptopToDelete;
    }
}
