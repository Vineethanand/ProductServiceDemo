package com.product.productservicedemo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponseDto {
    private String productName;
    private String productDescription;
}
