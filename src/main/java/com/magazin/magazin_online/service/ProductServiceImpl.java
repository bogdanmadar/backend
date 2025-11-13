package com.magazin.magazin_online.service;

import com.magazin.magazin_online.entity.Product;
import com.magazin.magazin_online.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchProductList() {
        return productRepository.findAll();
    }

    @Override
    public Product fetchProductById(Long produsId) {
        return productRepository.findById(produsId).get();
    }

    @Override
    public void deleteProductById(Long produsId) {
        productRepository.deleteById(produsId);
    }

    @Override
    public Product updateProduct(Long produsId, Product product) {

        Product prodDB = productRepository.findById(produsId).get();

        if(Objects.nonNull(product.getName()) && !"" .equalsIgnoreCase(product.getName())) {
            prodDB.setName(product.getName());
        }

        if(Objects.nonNull(product.getDescription()) && !"" .equalsIgnoreCase(product.getDescription())) {
            prodDB.setDescription(product.getDescription());
        }

        if(Objects.nonNull(product.getCategory()) && !"" .equalsIgnoreCase(product.getCategory())) {
            prodDB.setCategory(product.getCategory());
        }

        if(Objects.nonNull(product.getSubcategory()) && !"" .equalsIgnoreCase(product.getSubcategory())) {
            prodDB.setSubcategory(product.getSubcategory());
        }

        if(Objects.nonNull(product.getSellerName()) && !"" .equalsIgnoreCase(product.getSellerName())) {
            prodDB.setSellerName(product.getSellerName());
        }

        if(Objects.nonNull(product.getPrice()) && !(product.getPrice() < 0)) {
            prodDB.setPrice(product.getPrice());
        }

        if(Objects.nonNull(product.getQuantity()) && !(product.getQuantity() < 0)) {
            prodDB.setQuantity(product.getQuantity());
        }

        return productRepository.save(prodDB);
    }

    @Override
    public List<Product> fetchProductByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
}
