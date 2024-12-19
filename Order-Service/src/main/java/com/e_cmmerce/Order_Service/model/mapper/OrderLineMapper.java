package com.e_cmmerce.Order_Service.model.mapper;

import com.e_cmmerce.Order_Service.model.dto.Response.OrderLineResponse;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.OrderLineRequest;
import com.e_cmmerce.Order_Service.model.entities.Order;
import com.e_cmmerce.Order_Service.model.entities.OrderLine;
import org.springframework.stereotype.Component;

@Component
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.getOrderId())
                .productId(request.getProductId())
                .order(
                        Order.builder()
                                .id(request.getOrderId())
                                .build())
                .quantity(request.getQuantity())
                .build();
    }
    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return OrderLineResponse.builder()
                .id(orderLine.getId())
                .productId(orderLine.getProductId())
                .quantity(orderLine.getQuantity())
                .price(orderLine.getPrice())

                .build();
    }
}
