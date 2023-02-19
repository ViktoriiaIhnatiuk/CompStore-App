package com.example.compstore.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "desktop")
@DynamicInsert
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
@DiscriminatorColumn(name = "DESKTOP")
public class Desktop extends Computer {
    @Enumerated(EnumType.STRING)
    private CaseLightingColor caseLightingColor;

    public CaseLightingColor getCaseLightingColor() {
        return caseLightingColor;
    }

    public void setCaseLightingColor(CaseLightingColor caseLightingColor) {
        this.caseLightingColor = caseLightingColor;
    }

    @Override
    public String toString() {
        return super.toString() + '\n'
                + "caseLightingColor=" + caseLightingColor;
    }
}
