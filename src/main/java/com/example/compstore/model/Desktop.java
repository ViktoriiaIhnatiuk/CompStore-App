package com.example.compstore.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "desktop")
@DynamicInsert
@DynamicUpdate
public class Desktop extends Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private CaseLightingColor caseLightingColor;

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

    @Override
    public String toString() {
        return super.toString() + '\n'
                + "caseLightingColor=" + caseLightingColor + '\n'
                + "id=" + id;
    }
}
