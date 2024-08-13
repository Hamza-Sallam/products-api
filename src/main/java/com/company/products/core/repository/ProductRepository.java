package com.company.products.core.repository;

import java.util.List;

import com.company.products.core.entity.Product;


public interface ProductRepository {

Product create(Product product);
List<? extends Product> list(int page,int size);
Product getById(Long id);
boolean delete(Long id);

}
