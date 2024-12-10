package com.e_commerce.coustomer.repository;

import com.e_commerce.coustomer.model.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {

    List<Customer> findAllByIdInOrderById(List<String> customerIds);
    List<Customer>findAllById();
}
