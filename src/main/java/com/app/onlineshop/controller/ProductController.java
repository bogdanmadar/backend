package com.app.onlineshop.controller;

import com.app.onlineshop.entity.Product;
import com.app.onlineshop.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RequestMapping("/products")
@RestController

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    public List<Product> fetchProductList() {
        return productService.fetchProductList();
    }

    @GetMapping("/{id}")
    public Product fetchProductById(@PathVariable("id") Long productId) {
        return productService.fetchProductById(productId);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id") Long productId) {
        productService.deleteProductById(productId);
        return "Product deleted successfully!";
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long productId, @RequestBody Product product) {
        return productService.updateProduct(productId, product);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam(required = false) String name, @RequestParam(required = false) Double minPrice, @RequestParam(required = false) Double maxPrice) {
        return productService.searchProducts(name, minPrice, maxPrice);
    }
}
