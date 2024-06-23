package com.cristobits0101.springboot_ioc.repositories;

import java.util.Arrays;
import java.util.List;

import com.cristobits0101.springboot_ioc.models.Product;

public class ProductRepository {

    List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "Corsair", 300L),
                new Product(2L, "Intel", 300L));
    }

    public List<Product> findAll() {
        return this.data;
    }

    public Product findById(Long id) {
        return data
                .stream()                           // Convierte la colección data (que podría ser una lista, conjunto, etc.) en un Stream.
                .filter(p -> p.getId().equals(id))  // Filtro el Stream cuyo id = id, p es una variable lambda, representa cada elemento del Stream.
                .findFirst()                        // Devuelve un Optional con el primer elemento del Stream que pasa el filtro, si no un Optional vacío.
                .orElse(null);                // Si el optional esta vacío devuelve null.
    }

}
