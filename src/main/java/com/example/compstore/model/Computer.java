package com.example.compstore.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;


@JsonInclude(JsonInclude.Include.NON_NULL)
@DynamicUpdate
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Computer extends Item {
    @NotNull
    @Enumerated(EnumType.STRING)
    private ComputerType computerType;
    private String brandName;
    private String model;
    private String cpuManufacturer;
    private String processor;
    @PositiveOrZero
    private int processorCount;
    private String graphicsProcessor;
    @PositiveOrZero
    private int graphicsProcessorMemory;
    @PositiveOrZero
    private int ramSize;
    private HardDriveType hardDriveType;
    @PositiveOrZero
    private int hardDriveSize;
    private String operatingSystem;


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

    @Override
    public String toString() {
        return  super.toString() + '\n'
                + "computerType=" + computerType + '\n'
                + "brandName='" + brandName + '\'' + '\n'
                + "model='" + model + '\'' + '\n'
                + "cpuManufacturer='" + cpuManufacturer + '\'' + '\n'
                + "processor='" + processor + '\'' + '\n'
                + "processorCount=" + processorCount + '\n'
                + "graphicsProcessor='" + graphicsProcessor + '\'' + '\n'
                + "graphicsProcessorMemory=" + graphicsProcessorMemory + '\n'
                + "ramSize=" + ramSize + '\n'
                + "hardDriveType=" + hardDriveType + '\n'
                + "hardDriveSize=" + hardDriveSize + '\n'
                + "operatingSystem='" + operatingSystem + '\'';
    }
}


