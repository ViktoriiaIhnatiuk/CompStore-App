package com.example.compstore.dto.request;

import com.example.compstore.model.ComputerType;
import com.example.compstore.model.HardDriveType;

import java.math.BigDecimal;

public class LaptopRequestDto {
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
    private int displayDiagonalSize;
    private String displayResolution;
    private int refreshRate;
    private boolean touchScreenSupported;
    private boolean hasWebCam;
    private String webCamResolution;
    private Long id;
    private int batteryLifeTimeInHours;

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

    public int getDisplayDiagonalSize() {
        return displayDiagonalSize;
    }

    public void setDisplayDiagonalSize(int displayDiagonalSize) {
        this.displayDiagonalSize = displayDiagonalSize;
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public boolean isTouchScreenSupported() {
        return touchScreenSupported;
    }

    public void setTouchScreenSupported(boolean touchScreenSupported) {
        this.touchScreenSupported = touchScreenSupported;
    }

    public boolean isHasWebCam() {
        return hasWebCam;
    }

    public void setHasWebCam(boolean hasWebCam) {
        this.hasWebCam = hasWebCam;
    }

    public String getWebCamResolution() {
        return webCamResolution;
    }

    public void setWebCamResolution(String webCamResolution) {
        this.webCamResolution = webCamResolution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBatteryLifeTimeInHours() {
        return batteryLifeTimeInHours;
    }

    public void setBatteryLifeTimeInHours(int batteryLifeTimeInHours) {
        this.batteryLifeTimeInHours = batteryLifeTimeInHours;
    }
}
