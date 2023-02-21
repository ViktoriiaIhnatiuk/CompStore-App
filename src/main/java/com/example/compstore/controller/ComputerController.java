package com.example.compstore.controller;

import com.example.compstore.model.Computer;
import com.example.compstore.service.ComputerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/computers")
public class ComputerController {
    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping
    @ApiOperation("returns all computers from DB")
    public List<Computer> findAll() {
        return computerService.getAllComputers();
    }


    @GetMapping("/{id}")
    @ApiOperation("returns the computer with the concrete id from DB")
    public Computer getComputerById(@PathVariable Long id) throws Throwable {
        return computerService.get(id);
    }
}
