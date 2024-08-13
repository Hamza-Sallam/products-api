package com.company.products.Database;


import java.util.List;

import com.company.products.core.entity.Product;
import com.company.products.core.repository.ProductRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;




@ApplicationScoped
public class SQLProductRepository implements ProductRepository,PanacheRepository<SQLProductEntity>{


    @Override
    public List<? extends  Product> list(int page , int size){
        return findAll().page(Page.of(page,size)).list();

    }

    @Override
    public Product getById(Long id){
        return findById(id);
    }



    @Override
    @Transactional
    public Product create(Product product){
        Product new_product = SQLProductEntity.toEntity(product);
        persist((SQLProductEntity) new_product);
        return new_product;

    }
    @Override
    public boolean delete(Long id){
        return deleteById(id);

    }

}

