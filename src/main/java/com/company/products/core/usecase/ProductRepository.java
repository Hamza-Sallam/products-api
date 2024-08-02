package com.company.products.core.usecase;

import com.company.products.core.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<? extends Product> findAll(int page, int size);
    Product findById(Long id);
    Product create(Product product);
    boolean deleteById(Long id);
}




























