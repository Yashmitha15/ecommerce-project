package com.shop;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;
    private String category;
    
    @Column(name = "image_url")
    private String imageUrl;

    // Getters
    public Integer getId() { return id; }
    public String getName() { return name; }
    public Double getPrice() { return price; }
    public Integer getStock() { return stock; }
    public String getCategory() { return category; }
    public String getImageUrl() { return imageUrl; }
}