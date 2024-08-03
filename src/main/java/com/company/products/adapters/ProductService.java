package com.company.products.adapters;
import com.company.products.Database.SQLProductRepository;
import com.company.products.core.entity.Product;
import com.company.products.core.usecase.productUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProductService implements productUseCase{
    @Inject
    SQLProductRepository productRepository;

    public Product createProduct(Product product){
    return productRepository.create(product);
    }
    public List<? extends Product> getProducts(int page,int size){
        return productRepository.findAll(page,size);
    }
    public Product findById(Long id){
        return productRepository.findById(id);
    }
    public boolean deleteProduct(Long id){
        return productRepository.deleteById(id);
    }

}
