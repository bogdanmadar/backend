package com.magazin.magazin_online.service;

import com.magazin.magazin_online.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> fetchProductList();

    Product fetchProductById(Long productId);

    void deleteProductById(Long productId);

    Product updateProduct(Long productId, Product product);

    List<Product> searchProducts(String name, Double minPrice, Double maxPrice);
}
