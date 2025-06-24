package com.shopx.product_service.repository;

import com.shopx.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends MongoRepository<Product, UUID> {
    List<Product> findByNameContainingIgnoreCase(String name);
}
