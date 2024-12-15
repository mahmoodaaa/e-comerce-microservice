package com.e_cmmerce.Order_Service.model.dto.requsetDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineRequest {
    private String id;
    private String orderId;
    private String productId;
    private Double quantity;
    private Double price;
}
