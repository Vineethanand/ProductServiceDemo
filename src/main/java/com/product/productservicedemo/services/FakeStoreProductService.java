package com.product.productservicedemo.services;

import com.product.productservicedemo.dtos.FakeStoreProductDto;
import com.product.productservicedemo.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Primary
@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;
    private RedisTemplate<String, Object> redisTemplate;

    public FakeStoreProductService(RestTemplate restTemplate,
            RedisTemplate<String, Object> redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Product createProduct(String name, String description, Double price, String categoryName, String title) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {

        Product product = (Product) redisTemplate.opsForHash().get("PRODUCTS", "PRODUCT_" + id);
        if (product != null) {
            return product;
        }
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        if(fakeStoreProductDto != null) {
            product=  fakeStoreProductDto.convertFakeStoreProductDtotoProduct();
            redisTemplate.opsForHash().put("PRODUCTS", "PRODUCT_" + id, product);
            return product;
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
