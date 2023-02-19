package com.example.compstore.controller;

import com.example.compstore.dto.request.DesktopRequestDto;
import com.example.compstore.dto.response.DesktopResponseDto;
import com.example.compstore.mapper.DesktopMapper;
import com.example.compstore.service.DesktopService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/desktops")
public class DesktopController {
    private final DesktopService desktopService;
    private final DesktopMapper desktopMapper;

    public DesktopController(DesktopService desktopService,
                             DesktopMapper desktopMapper) {
        this.desktopService = desktopService;
        this.desktopMapper = desktopMapper;
    }


    @PostMapping
    @ApiOperation("inserts a new desktop into DB")
    public DesktopResponseDto createDesktop(@Valid @RequestBody DesktopRequestDto desktopRequestDto) {
        return desktopMapper.mapToDto(desktopService.create(desktopMapper.mapToModel(desktopRequestDto)));
    }

    @GetMapping
    @ApiOperation("returns all desktops from DB")
    public List<DesktopResponseDto> getAllDesktops() {
        return desktopService.getAll().stream()
                .map(desktopMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation("returns the desktop with the concrete id from DB")
    public DesktopResponseDto getDesktopById(@PathVariable Long id) {
        return desktopMapper.mapToDto(desktopService.get(id));
    }

    @PatchMapping("/{id}")
    @ApiOperation("updates the desktop with the concrete id")
    public DesktopResponseDto updateDesktopById(@PathVariable Long id,
                                   @Valid @RequestBody DesktopRequestDto desktopRequestDto) {
        return desktopMapper.mapToDto(desktopService.update(id,
                desktopMapper.mapToModel(desktopRequestDto)));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("deletes the desktop with the concrete id from DB")
    public DesktopResponseDto deleteDesktopById(@PathVariable Long id) {
        return desktopMapper.mapToDto(desktopService.delete(id));
    }
}
