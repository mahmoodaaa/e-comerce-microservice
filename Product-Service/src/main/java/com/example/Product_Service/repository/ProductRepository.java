package com.example.Product_Service.repository;

import com.example.Product_Service.model.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {

    List<Product>findAllByIdInOrderById(List<String> productsIds);
    List<Product> findByIdInOrderById(List<String> productIds);
    List<Product> findByNameContainingIgnoreCase(String name);
}
