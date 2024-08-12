package com.company.products.Database;

import com.company.products.core.entity.Product;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductPanacheRepository implements PanacheRepository<Product> {

}
