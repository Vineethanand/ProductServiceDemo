package com.product.productservicedemo.services;

import com.product.productservicedemo.models.Product;
import com.product.productservicedemo.repositories.ProductRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.util.List;

@Service
public class SearchService {
    private ProductRepo productRepo;

    public SearchService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getProductwithTitle(String keyword, int pageno, int pagesize) {
        return productRepo.findProductByTitleContains(keyword, PageRequest.of(pageno, pagesize, Sort.by(Sort.Direction.ASC,"price")));
    }
}
