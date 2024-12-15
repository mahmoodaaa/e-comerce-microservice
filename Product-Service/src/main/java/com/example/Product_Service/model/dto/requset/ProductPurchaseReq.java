package com.example.Product_Service.model.dto.requset;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPurchaseReq {
    private String productId;
    private Double quantity;


}
