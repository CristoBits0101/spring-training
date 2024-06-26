package com.cristobits0101.ioc.ioc.repositories;

import java.util.Arrays;
import java.util.List;

import com.cristobits0101.ioc.ioc.models.Product;

public class ProductRepository {

    List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "Corsair", 300L),
                new Product(2L, "Intel", 150L),
                new Product(3L, "AMD", 75L));
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {
        return data
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
