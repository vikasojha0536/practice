package com.example.springbook.modal;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Product extends AbstractEntity {
    private String name;
    private String description;
    private BigDecimal price;
    @ElementCollection
    private Map<String, String> attributes = new HashMap<>();

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public Product setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
        return this;
    }
}
