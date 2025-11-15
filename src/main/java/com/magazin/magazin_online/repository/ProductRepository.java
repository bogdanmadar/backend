package com.magazin.magazin_online.repository;

import com.magazin.magazin_online.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Object> findByName(String name);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByPriceBetween(double min, double max);
}
