package com.company.products.adapters;

import com.company.products.core.entity.Product;
import com.company.products.core.usecase.ProductUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProductService {
    @Inject
    ProductUseCase productUseCase;

    public Product createProduct(Product product){
    return productUseCase.createProduct(product);
    }
    public List<? extends Product> getProducts(int page,int size){
        return productUseCase.getProducts(page,size);
    }
    public Product findById(Long id){
        return productUseCase.findProductById(id);
    }
    public boolean deleteProduct(Long id){
        return productUseCase.deleteProduct(id);
    }

}
