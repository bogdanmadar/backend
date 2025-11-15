package com.magazin.magazin_online.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String name;
    private String description;
    private String category;
    private String subcategory;
    private String sellerName;
    private Double price;
    private Long quantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descriere) {
        this.description = descriere;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String categorie) {
        this.category = categorie;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategorie) {
        this.subcategory = subcategorie;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String numeVanzator) {
        this.sellerName = numeVanzator;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double pret) {
        this.price = pret;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long cantitate) {
        this.quantity = cantitate;
    }

    public Product(Long productId, String name, String description, String category, String sellerName, String subcategory, Long quantity, Double price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.sellerName = sellerName;
        this.subcategory = subcategory;
        this.quantity = quantity;
        this.price = price;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Produs{" +
                "produsId=" + productId +
                ", nume='" + name + '\'' +
                ", descriere='" + description + '\'' +
                ", categorie='" + category + '\'' +
                ", subcategorie='" + subcategory + '\'' +
                ", numeVanzator='" + sellerName + '\'' +
                ", pret=" + price +
                ", cantitate=" + quantity +
                '}';
    }
}
