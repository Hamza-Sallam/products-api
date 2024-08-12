package com.company.products.core.usecase;

import java.util.List;

import com.company.products.core.entity.Product;

public interface ProductUseCase {
    Product createProduct(Product product);
    List<? extends Product> getProducts(int page,int size);
    Product findProductById(Long id);
    boolean deleteProductById(Long id);

}
