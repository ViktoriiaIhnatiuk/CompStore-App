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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int batteryLifeTimeInHours;

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

    @Override
    public String toString() {
        return  super.toString() + '\n' +
                "batteryLifeTimeInHours=" + batteryLifeTimeInHours  + '\n' +
                "id=" + id;
    }
}
