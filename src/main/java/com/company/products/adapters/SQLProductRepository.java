package com.company.products.adapters;


import com.company.products.core.usecase.ProductRepository;
import com.company.products.core.entity.Product;
import jakarta.transaction.Transactional;
import jakarta.inject.*;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;




@ApplicationScoped
public class SQLProductRepository implements ProductRepository {
    @Inject
    ProductPanacheRepository productPanacheRepository;


    @Override
    public List<? extends  Product> findAll(int page , int size){
        return productPanacheRepository.findAll().page(page, size).list();

    }
    @Override
    public Product findById(Long id){
        return productPanacheRepository.findById(id);
    }



    @Override
    @Transactional
    public Product create(Product product){
        Product new_product = SQLProductEntity.fromDto(product);
        productPanacheRepository.persist((SQLProductEntity) new_product);
        return new_product;

    }
    @Override
    public boolean deleteById(Long id){
        return productPanacheRepository.deleteById(id);

    }

}