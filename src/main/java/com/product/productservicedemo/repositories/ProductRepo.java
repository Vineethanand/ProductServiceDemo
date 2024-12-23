package com.product.productservicedemo.repositories;

import com.product.productservicedemo.models.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findProductByTitleContains(String keyword, PageRequest pagerequest);
}
