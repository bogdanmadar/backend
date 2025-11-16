package com.app.onlineshop.service;

import com.app.onlineshop.entity.Product;
import com.app.onlineshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchProductList() {
        return productRepository.findAll();
    }

    @Override
    public Product fetchProductById(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {

        Product prodDB = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (Objects.nonNull(product.getName()) && !"".equalsIgnoreCase(product.getName())) {
            prodDB.setName(product.getName());
        }

        if (Objects.nonNull(product.getDescription()) && !"".equalsIgnoreCase(product.getDescription())) {
            prodDB.setDescription(product.getDescription());
        }

        if (Objects.nonNull(product.getCategory()) && !"".equalsIgnoreCase(product.getCategory())) {
            prodDB.setCategory(product.getCategory());
        }

        if (Objects.nonNull(product.getSubcategory()) && !"".equalsIgnoreCase(product.getSubcategory())) {
            prodDB.setSubcategory(product.getSubcategory());
        }

        if (Objects.nonNull(product.getSellerName()) && !"".equalsIgnoreCase(product.getSellerName())) {
            prodDB.setSellerName(product.getSellerName());
        }

        if (Objects.nonNull(product.getPrice()) && !(product.getPrice() < 0)) {
            prodDB.setPrice(product.getPrice());
        }

        if (Objects.nonNull(product.getQuantity()) && !(product.getQuantity() < 0)) {
            prodDB.setQuantity(product.getQuantity());
        }

        return productRepository.save(prodDB);
    }

    @Override
    public List<Product> searchProducts(String name, Double minPrice, Double maxPrice) {

        return productRepository.findByNameAndPriceBetween(name, minPrice, maxPrice);
    }
}
