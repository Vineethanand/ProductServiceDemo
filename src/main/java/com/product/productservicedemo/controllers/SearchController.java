package com.product.productservicedemo.controllers;

import com.product.productservicedemo.models.Product;
import com.product.productservicedemo.services.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService)
    {
        this.searchService = searchService;
    }


    @GetMapping
    public List<Product> searchProduct(
            @RequestParam String keyword,
            @RequestParam(value = "pageno", defaultValue = "0")int pageno,
            @RequestParam(value = "pagesize", defaultValue = "10")int pagesize){
        return searchService.getProductwithTitle(keyword, pageno, pagesize);
    }

}
