package com.example.compstore.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
@DynamicInsert
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
@DiscriminatorColumn(name = "LAPTOP")
public class Laptop extends DisplayIncludedComputer {
    private int batteryLifeTimeInHours;

    public int getBatteryLifeTimeInHours() {
        return batteryLifeTimeInHours;
    }

    public void setBatteryLifeTimeInHours(int batteryLifeTimeInHours) {
        this.batteryLifeTimeInHours = batteryLifeTimeInHours;
    }

    @Override
    public String toString() {
        return  super.toString() + '\n' +
                "batteryLifeTimeInHours=" + batteryLifeTimeInHours;
    }
}
