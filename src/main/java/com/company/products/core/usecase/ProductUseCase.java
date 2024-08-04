package com.company.products.core.usecase;

import com.company.products.core.entity.Product;

import java.util.List;

public interface ProductUseCase {
    Product createProduct(Product product);
    List<? extends Product> getProducts(int page,int size);
    Product findProductById(Long id);
    boolean deleteProduct(Long id);

}
