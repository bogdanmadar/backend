package com.magazin.magazin_online.controller;

import com.magazin.magazin_online.entity.Product;
import com.magazin.magazin_online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:5173")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/products")
    public List<Product> fetchProductList() {
        return productService.fetchProductList();
    }

    @GetMapping("/products/{id}")
    public Product fetchProductById(@PathVariable("id") Long productId) {
        return productService.fetchProductById(productId);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable("id") Long productId) {
        productService.deleteProductById(productId);
        return "Produs sters!";
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long productId, @RequestBody Product product) {
        return productService.updateProduct(productId, product);
    }

    @GetMapping("/name/{name}")
    public List<Product> fetchProductByName(@PathVariable("name") String name) {
        return productService.fetchProductByName(name);
    }
}
