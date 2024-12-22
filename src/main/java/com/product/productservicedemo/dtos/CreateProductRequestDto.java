package com.product.productservicedemo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private String name;
    private String description;
    private Double price;
    private String categoryName;
    private String title;
}
