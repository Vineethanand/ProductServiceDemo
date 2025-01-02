package com.product.productservicedemo.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity(name="category")
public class Category extends BaseModel implements Serializable {
}
