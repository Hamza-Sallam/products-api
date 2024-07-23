package com.company.products;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Error: the name of the product can not be blank")
    private String name;
    private String description;

    @NotNull
    @Digits(message = "Error: Price must be a number with 2 DP", integer = 10, fraction = 2)
    @Positive(message = "Error: price cannot be negative")
    private double price;

    private String image;

    // Getters and Setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public String getImage() {return image;}
    public void setImage(String image) {this.image = image;}



}