package com.example.compstore.dto.response;

import com.example.compstore.model.CaseLightingColor;
import com.example.compstore.model.ComputerType;
import com.example.compstore.model.HardDriveType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DesktopResponseDto {
    private ComputerType computerType;
    private String brandName;
    private String model;
    private String cpuManufacturer;
    private String processor;
    private int processorCount;
    private String graphicsProcessor;
    private int graphicsProcessorMemory;
    private int ramSize;
    private HardDriveType hardDriveType;
    private int hardDriveSize;
    private String operatingSystem;
    private String description;
    private BigDecimal price;
    private Long id;
    private CaseLightingColor caseLightingColor;

    public ComputerType getComputerType() {
        return computerType;
    }

    public void setComputerType(ComputerType computerType) {
        this.computerType = computerType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCpuManufacturer() {
        return cpuManufacturer;
    }

    public void setCpuManufacturer(String cpuManufacturer) {
        this.cpuManufacturer = cpuManufacturer;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getProcessorCount() {
        return processorCount;
    }

    public void setProcessorCount(int processorCount) {
        this.processorCount = processorCount;
    }

    public String getGraphicsProcessor() {
        return graphicsProcessor;
    }

    public void setGraphicsProcessor(String graphicsProcessor) {
        this.graphicsProcessor = graphicsProcessor;
    }

    public int getGraphicsProcessorMemory() {
        return graphicsProcessorMemory;
    }

    public void setGraphicsProcessorMemory(int graphicsProcessorMemory) {
        this.graphicsProcessorMemory = graphicsProcessorMemory;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public HardDriveType getHardDriveType() {
        return hardDriveType;
    }

    public void setHardDriveType(HardDriveType hardDriveType) {
        this.hardDriveType = hardDriveType;
    }

    public int getHardDriveSize() {
        return hardDriveSize;
    }

    public void setHardDriveSize(int hardDriveSize) {
        this.hardDriveSize = hardDriveSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CaseLightingColor getCaseLightingColor() {
        return caseLightingColor;
    }

    public void setCaseLightingColor(CaseLightingColor caseLightingColor) {
        this.caseLightingColor = caseLightingColor;
    }
}
