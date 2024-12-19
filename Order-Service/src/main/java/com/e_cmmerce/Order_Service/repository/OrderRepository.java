package com.e_cmmerce.Order_Service.repository;

import com.e_cmmerce.Order_Service.model.dto.Response.OrderResponse;
import com.e_cmmerce.Order_Service.model.entities.Order;

import com.e_cmmerce.Order_Service.model.enums.OrderStatus;
import com.e_cmmerce.Order_Service.model.enums.PaymentMethod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {

    Page<Order> findAll(Pageable pageable);
    @Query("{ 'totalPrice': { $gte: ?0, $lte: ?1 } }")
    List<Order> findOrdersByPriceRange(Double minPrice, Double maxPrice);
    @Query("{ $and: [ " +
            "{ $or: [ { 'orderDate': { $gte: ?0, $lte: ?1 } }, { } ] }, " +
            "{ $or: [ { 'status': ?2 }, { } ] }, " +
            "{ $or: [ { 'paymentMethod': ?3 }, { } ] } " +
            "] }")
    List<Order> searchOrders(LocalDateTime startDate, LocalDateTime endDate, OrderStatus status, PaymentMethod paymentMethod);

}
