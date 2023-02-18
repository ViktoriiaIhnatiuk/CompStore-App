package com.example.compstore.controller;

import com.example.compstore.dto.request.AllInOneRequestDto;
import com.example.compstore.dto.response.AllInOneResponseDto;
import com.example.compstore.mapper.AllInOneMapper;
import com.example.compstore.service.AllInOneService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/all-in-one")
public class AllInOneController {
    private final AllInOneService allInOneService;
    private final AllInOneMapper allInOneMapper;

    public AllInOneController(AllInOneService allInOneService,
                              AllInOneMapper allInOneMapper) {
        this.allInOneService = allInOneService;
        this.allInOneMapper = allInOneMapper;
    }

    @PostMapping
    @ApiOperation("inserts a new all-in-one into DB")
    public AllInOneResponseDto createAllInOne(@RequestBody AllInOneRequestDto allInOneRequestDto) {
        return allInOneMapper.mapToDto(allInOneService.create(allInOneMapper.mapToModel(allInOneRequestDto)));
    }

    @GetMapping
    @ApiOperation("returns all all-in-one from DB")
    public List<AllInOneResponseDto> getAllAllInOne() {
        return allInOneService.getAll().stream()
                .map(allInOneMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation("returns the all-in-one with the concrete id from DB")
    public AllInOneResponseDto getAllInOneById(@PathVariable Long id) {
        return allInOneMapper.mapToDto(allInOneService.get(id));
    }

    @PatchMapping("/{id}")
    @ApiOperation("updates the all-in-one with the concrete id")
    public AllInOneResponseDto updateLaptopById(@PathVariable Long id,
                                   @RequestBody AllInOneRequestDto allInOneRequestDto) {
        return allInOneMapper.mapToDto(allInOneService.update(id,
                allInOneMapper.mapToModel(allInOneRequestDto)));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("deletes the laptop with the concrete id from DB")
    public AllInOneResponseDto deleteAllInOneById(@PathVariable Long id) {
        return allInOneMapper.mapToDto(allInOneService.delete(id));
    }
}
