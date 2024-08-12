package com.company.products.Database;


import java.util.List;

import com.company.products.core.entity.Product;
import com.company.products.core.repository.ProductRepository;

import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;




@ApplicationScoped
public class SQLProductRepository implements ProductRepository{
@ Inject
ProductPanacheRepository repository; 

    @Override
    public List<? extends  Product> list(int page , int size){
        return repository.findAll().page(Page.of(page,size)).list();

    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }



    @Override
    @Transactional
    public Product create(Product product){
        Product new_product = SQLProductEntity.toEntity(product);
        repository.persist((SQLProductEntity) new_product);
        return new_product;

    }
    @Override
    public boolean deleteById(Long id){
        return repository.deleteById(id);

    }

}

