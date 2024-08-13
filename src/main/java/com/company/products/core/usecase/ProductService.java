package com.company.products.core.usecase;

import java.util.List;

import com.company.products.core.entity.Product;
import com.company.products.core.repository.ProductRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class ProductService implements ProductUseCase {
    @Inject
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product){
    return productRepository.create(product);
    }
    @Override
    public List<? extends Product> getProducts(int page,int size){
        return productRepository.list(page,size);
    }
    
    @Override
    public Product findProductById(Long id){
        return productRepository.getById(id);
    }
    @Override
    public boolean deleteProductById(Long id){
        return productRepository.delete(id);
    }

}
