package com.e_cmmerce.Order_Service.model.dto.requsetDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPurchaseReq {


    @NotNull(message = "Product is mandatory")
    private String productId;
    @Positive(message = "Quantity is mandatory")
    private Double quantity;

}
