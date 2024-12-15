package com.e_cmmerce.Order_Service.model.mapper;

import com.e_cmmerce.Order_Service.model.dto.Response.OrderLineResponse;
import com.e_cmmerce.Order_Service.model.dto.Response.OrderResponse;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.OrderRequest;
import com.e_cmmerce.Order_Service.model.entities.Order;
import com.e_cmmerce.Order_Service.model.entities.OrderLine;
import com.e_cmmerce.Order_Service.model.enums.OrderStatus;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public Order toEntity(OrderRequest orderRequest) {
        if (orderRequest == null) {
            return null;
        }

        return Order.builder()
                .customerId(orderRequest.getCustomerId())
                .paymentMethod(orderRequest.getPaymentMethod())
                .orderLine(orderRequest.getProducts().stream()
                        .map(product -> OrderLine.builder()
                                .productId(product.getProductId())
                                .quantity(product.getQuantity())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public OrderResponse toResponse(Order order) {
        if (order == null) {
            return null;
        }

        return OrderResponse.builder()
                .id(order.getId())
                .reference(order.getReference())
                .totalAmount(order.getTotalAmount())
                .paymentMethod(order.getPaymentMethod())
                .orderStatus(OrderStatus.DELIVERED)
                .customerId(order.getCustomerId())
                .createdAt(order.getCreatedAt())
                .orderLine(
                        order.getOrderLine().stream()
                                .map(orderLine -> OrderLineResponse.builder()
                                        .id(orderLine.getId())
                                        .productId(orderLine.getProductId())
                                        .quantity(orderLine.getQuantity())
                                        .price(orderLine.getPrice())
                                        .build()
                                )
                                .collect(Collectors.toList())
                )
                .build();
    }

}
