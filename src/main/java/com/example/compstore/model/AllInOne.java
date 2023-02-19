package com.example.compstore.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "all_in_one")
@DynamicInsert
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
@DiscriminatorColumn(name = "ALL_IN_ONE")
public class AllInOne extends DisplayIncludedComputer {
    @Override
    public String toString() {
        return super.toString();
    }
}
