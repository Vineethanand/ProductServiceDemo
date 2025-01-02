package com.product.productservicedemo.dtos;

import com.product.productservicedemo.models.Category;
import com.product.productservicedemo.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public class FakeStoreProductDto {
    Integer id;
    String title;
    Double price;
    String description;
    String Category;

    public Product convertFakeStoreProductDtotoProduct()
    {
        Product product = new Product();
        product.setTitle(this.getTitle());
        product.setPrice(this.getPrice());
        product.setDescription(this.getDescription());
        product.setId(this.getId());
        Category category = new Category();
        category.setTitle(this.getCategory());
        product.setCategory(category);
        return product;
    }
}
