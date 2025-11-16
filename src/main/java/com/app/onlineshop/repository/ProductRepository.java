package com.app.onlineshop.repository;

import com.app.onlineshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
                SELECT p FROM Product p
                WHERE (:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))
                  AND (:min IS NULL OR p.price >= :min)
                  AND (:max IS NULL OR p.price <= :max)
            """)
    List<Product> findByNameAndPriceBetween(@Param("name") String name, @Param("min") Double minPrice, @Param("max") Double maxPrice);
}
