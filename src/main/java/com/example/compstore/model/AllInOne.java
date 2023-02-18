package com.example.compstore.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "all_in_one")
@DynamicInsert
@DynamicUpdate
public class AllInOne extends DisplayIncludedComputer {
    @Override
    public String toString() {
        return super.toString();
    }
}
