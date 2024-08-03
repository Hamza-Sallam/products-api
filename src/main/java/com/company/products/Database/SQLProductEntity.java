package com.company.products.Database;

import com.company.products.core.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class SQLProductEntity extends Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message="Error: the name of the product can not be blank")
    public String name;
    public String description;
    @NotNull
    @Digits(message = "Error: Price must be a number with 2 DP", integer = 10, fraction = 2)
    @Positive(message = "Error: price cannot be negative")
    public double price;
    public String image;

    public SQLProductEntity() {}

    public static Product fromDto(Product product){
        return new SQLProductEntity(product.getId(),product.getName(),product.getDescription(),product.getPrice(),product.getImage());
    }

    public SQLProductEntity(Long id, String name, String description, double price, String image) {
        this.description=description;
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;

    }
}