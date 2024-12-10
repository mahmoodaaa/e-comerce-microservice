package com.e_cmmerce.Order_Service.model.dto.Response;

import com.e_cmmerce.Order_Service.model.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String id;
    private String reference;
    private Double totalAmount;
    private PaymentMethod paymentMethod;
    private String customerId;

}
