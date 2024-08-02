package com.company.products.core.entity;


public class Product {
     Long id;
     String name;
     String description;
     double price;
     String image;


    // Getters and Setters
    public Long getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public String getImage() {return image;}
    public void setImage(String image) {this.image = image;}
}
