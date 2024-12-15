package com.e_cmmerce.Order_Service.model.dto.Response;

import com.e_cmmerce.Order_Service.model.entities.OrderLine;
import com.e_cmmerce.Order_Service.model.enums.OrderStatus;
import com.e_cmmerce.Order_Service.model.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String id;
    private String reference;
    private List<OrderLineResponse> orderLine;
    private Double totalAmount;
    private PaymentMethod paymentMethod;
    private OrderStatus orderStatus  ;
    private String customerId;
    private LocalDateTime createdAt;
}
