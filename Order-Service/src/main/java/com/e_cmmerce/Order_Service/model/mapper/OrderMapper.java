package com.e_cmmerce.Order_Service.model.mapper;

import com.e_cmmerce.Order_Service.model.dto.Response.OrderResponse;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.OrderRequest;
import com.e_cmmerce.Order_Service.model.entities.Order;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
@Configuration
public class OrderMapper {

    public Order toEntity(OrderRequest request){
        if (request == null) {
            return null;
        }
        return  Order.builder()
                .customerId(request.getCustomerId())
                .reference(request.getReference())
                .totalAmount(request.getTotalAmount())
                .paymentMethod(request.getPaymentMethod())
                .createdAt(LocalDateTime.now())
                .orderLine(new ArrayList<>())
                .build();
    }
    public OrderResponse toResponse(Order order){
        return  OrderResponse.builder()
                .id(order.getId())
                .reference(order.getReference())
                .totalAmount(order.getTotalAmount())
                .paymentMethod(order.getPaymentMethod())
                .customerId(order.getCustomerId())
                .build();
    }
}
