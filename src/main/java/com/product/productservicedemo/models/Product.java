package com.product.productservicedemo.models;

import com.product.productservicedemo.dtos.FakeStoreProductDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity(name="products")
public class Product extends BaseModel implements Serializable {
    private String name;
    private String description;
    private double price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    Category category;
}
