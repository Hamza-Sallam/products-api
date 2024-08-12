package com.company.products.core.repository;

import java.util.List;

import com.company.products.core.entity.Product;


public interface ProductRepository {

Product create(Product product);
List<? extends Product> list(int page,int size);
Product findById(Long id);
boolean deleteById(Long id);

}
