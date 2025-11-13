package com.magazin.magazin_online.service;

import com.magazin.magazin_online.entity.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);

    public List<Product> fetchProductList();

    public Product fetchProductById(Long productId);

    public void deleteProductById(Long productId);

    public Product updateProduct(Long productId, Product product);

    public List<Product> fetchProductByName(String name);
}
