package com.company.products.Database;


import com.company.products.adapters.ProductPanacheRepository;
import com.company.products.core.entity.Product;
import com.company.products.core.usecase.productUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;




@ApplicationScoped
public class SQLProductRepository implements productUseCase {
    @Inject
    ProductPanacheRepository productPanacheRepository;


    @Override
    public List<? extends  Product> getProducts(int page , int size){
        return productPanacheRepository.findAll().page(page, size).list();

    }
    @Override
    public Product findById(Long id){
        return productPanacheRepository.findById(id);
    }



    @Override
    @Transactional
    public Product createProduct(Product product){
        Product new_product = SQLProductEntity.fromDto(product);
        productPanacheRepository.persist((SQLProductEntity) new_product);
        return new_product;

    }
    @Override
    public boolean deleteProduct(Long id){
        return productPanacheRepository.deleteById(id);

    }

}