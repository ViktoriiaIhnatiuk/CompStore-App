package com.example.compstore.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
@DynamicInsert
@DynamicUpdate
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
