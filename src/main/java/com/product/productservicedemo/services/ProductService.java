package com.product.productservicedemo.services;

import com.product.productservicedemo.models.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    Product createProduct(String name, String description, Double price, String categoryName, String title);

    Product getProduct(Long id);
}
