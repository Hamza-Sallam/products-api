package com.company.products.Database;


import com.company.products.core.entity.Product;
import com.company.products.core.usecase.ProductUseCase;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;




@ApplicationScoped
public class SQLProductRepository implements ProductUseCase,PanacheRepository<SQLProductEntity> {


    @Override
    public List<? extends  Product> getProducts(int page , int size){
        return findAll().page(page, size).list();

    }

    @Override
    public Product findProductById(Long id){
        return findById(id);
    }



    @Override
    @Transactional
    public Product createProduct(Product product){
        Product new_product = SQLProductEntity.fromDto(product);
        persist((SQLProductEntity) new_product);
        return new_product;

    }
    @Override
    public boolean deleteProduct(Long id){
        return deleteById(id);

    }

}

