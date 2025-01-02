package com.product.productservicedemo.services;


import com.product.productservicedemo.models.Category;
import com.product.productservicedemo.models.Product;
import com.product.productservicedemo.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService {

    ProductRepo productRepo;

    public SelfProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product createProduct(String name, String description, Double price, String categoryName, String title) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setTitle(title);
        Category category = new Category();
        category.setTitle(categoryName);
        product.setCategory(category);
        return productRepo.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
