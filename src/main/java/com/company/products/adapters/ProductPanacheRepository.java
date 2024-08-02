package com.company.products.adapters;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductPanacheRepository implements PanacheRepository<SQLProductEntity> {
}