package com.company.products.service;

import java.util.List;

import com.company.products.Database.SQLProductRepository;
import com.company.products.core.entity.Product;
import com.company.products.core.usecase.ProductUseCase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class ProductService implements ProductUseCase {
    @Inject
    SQLProductRepository sqlProductRepository;

    @Override
    public Product createProduct(Product product){
    return sqlProductRepository.create(product);
    }
    @Override
    public List<? extends Product> getProducts(int page,int size){
        return sqlProductRepository.list(page,size);
    }
    
    @Override
    public Product findProductById(Long id){
        return sqlProductRepository.findById(id);
    }
    @Override
    public boolean deleteProductById(Long id){
        return sqlProductRepository.deleteById(id);
    }

}
