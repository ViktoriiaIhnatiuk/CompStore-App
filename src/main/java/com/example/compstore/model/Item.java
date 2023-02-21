package com.example.compstore.model;

import java.math.BigDecimal;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ItemType itemType;
    private String name;
    private String description;
    @PositiveOrZero
    private BigDecimal price;
    private boolean deleted;

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "id=" + id + '\n'
                + "itemType='" + itemType + '\'' + '\n'
                + "name='" + name + '\'' + '\n'
                + "description='" + description + '\'' + '\n'
                + "price=" + price + " $" + '\n'
                + "deleted=" + deleted;
    }
}
