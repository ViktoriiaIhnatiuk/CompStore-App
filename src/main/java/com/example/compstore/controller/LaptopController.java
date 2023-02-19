package com.example.compstore.controller;

import com.example.compstore.dto.request.LaptopRequestDto;
import com.example.compstore.dto.response.LaptopResponseDto;
import com.example.compstore.mapper.LaptopMapper;
import com.example.compstore.service.LaptopService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
    private final LaptopService laptopService;
    private final LaptopMapper laptopMapper;

    public LaptopController(LaptopService laptopService,
                            LaptopMapper laptopMapper) {
        this.laptopService = laptopService;
        this.laptopMapper = laptopMapper;
    }

    @PostMapping
    @ApiOperation("inserts a new laptop into DB")
    public LaptopResponseDto createLaptop(@Valid @RequestBody LaptopRequestDto laptopRequestDto) {
        return laptopMapper.mapToDto(laptopService.create(laptopMapper.mapToModel(laptopRequestDto)));
    }

    @GetMapping
    @ApiOperation("returns all laptops from DB")
    public List<LaptopResponseDto> getAllLaptops() {
        return laptopService.getAll().stream()
                .map(laptopMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation("returns the laptop with the concrete id from DB")
    public LaptopResponseDto getLaptopById(@PathVariable Long id) {
        return laptopMapper.mapToDto(laptopService.get(id));
    }

    @PatchMapping("/{id}")
    @ApiOperation("updates the laptop with the concrete id")
    public LaptopResponseDto updateLaptopById(@PathVariable Long id,
                                  @Valid @RequestBody LaptopRequestDto laptopRequestDto) {
        return laptopMapper.mapToDto(laptopService.update(id,
                laptopMapper.mapToModel(laptopRequestDto)));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("deletes the laptop with the concrete id from DB")
    public LaptopResponseDto deleteLaptopById(@PathVariable Long id) {
        return laptopMapper.mapToDto(laptopService.delete(id));
    }
}
