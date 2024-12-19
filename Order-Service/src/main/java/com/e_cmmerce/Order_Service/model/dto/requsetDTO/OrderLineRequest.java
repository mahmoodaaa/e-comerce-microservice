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
public class OrderLineRequest {

    private String orderId;

    private String productId;
    @NotNull(message = "Quantity is required.")
    @Positive(message = "Quantity must be greater than zero.")
    private Double quantity;
    @NotNull(message = "Price is required.")
    @Positive(message = "Price must be greater than zero.")
    private Double price;
}
