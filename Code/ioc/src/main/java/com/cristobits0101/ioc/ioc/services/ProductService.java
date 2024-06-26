package com.cristobits0101.ioc.ioc.services;

import java.util.List;
import java.util.stream.Collectors;

import com.cristobits0101.ioc.ioc.models.Product;
import com.cristobits0101.ioc.ioc.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {
        return repository
            .findAll()
            .stream()
            .map(p -> {
                Double priceTax = p.getPrice() * 1.25d;
                Product newProduct = new Product(p.getId(), p.getName(), priceTax.longValue());
                return newProduct;
            }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }

}
