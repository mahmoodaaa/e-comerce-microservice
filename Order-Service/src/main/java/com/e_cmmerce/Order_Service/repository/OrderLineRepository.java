package com.e_cmmerce.Order_Service.repository;

import com.e_cmmerce.Order_Service.model.entities.OrderLine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends MongoRepository<OrderLine,String> {
}
