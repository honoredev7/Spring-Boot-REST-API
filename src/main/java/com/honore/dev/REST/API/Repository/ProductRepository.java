package com.honore.dev.REST.API.Repository;

import com.honore.dev.REST.API.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
