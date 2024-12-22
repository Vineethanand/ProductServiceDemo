package com.product.productservicedemo.services;

import com.product.productservicedemo.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    Product createProduct(String name, String description, Double price, String categoryName, String title);

    Product getProduct(Long id);

    List<Product> getAllProducts();
}
