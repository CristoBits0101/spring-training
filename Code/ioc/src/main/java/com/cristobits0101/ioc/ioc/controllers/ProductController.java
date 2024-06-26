package com.cristobits0101.ioc.ioc.controllers;

import com.cristobits0101.ioc.ioc.models.Product;
import com.cristobits0101.ioc.ioc.services.ProductService;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductService productService = new ProductService();

    @GetMapping("/product")
    public List<Product> list() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return productService.findById(id);
    }

}
