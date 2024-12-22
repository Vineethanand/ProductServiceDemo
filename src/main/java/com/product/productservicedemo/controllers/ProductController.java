package com.product.productservicedemo.controllers;

import com.product.productservicedemo.dtos.CreateProductRequestDto;
import com.product.productservicedemo.dtos.CreateProductResponseDto;
import com.product.productservicedemo.models.Product;
import com.product.productservicedemo.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<CreateProductResponseDto> createProduct(@RequestBody CreateProductRequestDto createProductRequestDto)
    {
        Product product = productService.createProduct(createProductRequestDto.getName(),
                createProductRequestDto.getDescription(),
                createProductRequestDto.getPrice(),
                createProductRequestDto.getCategoryName(),
                createProductRequestDto.getTitle());
        CreateProductResponseDto createProductResponseDtoResponse = new CreateProductResponseDto();
        createProductResponseDtoResponse.setProductName(product.getName());
        createProductResponseDtoResponse.setProductDescription(product.getDescription());
        return new ResponseEntity<>(createProductResponseDtoResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id)
    {
        Product product = productService.getProduct(id);
        if(product != null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}