package com.example.compstore.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "all_in_one")
@DynamicInsert
@DynamicUpdate
public class AllInOne extends DisplayIncludedComputer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString() + '\n'
                + "id=" + id;
    }
}
