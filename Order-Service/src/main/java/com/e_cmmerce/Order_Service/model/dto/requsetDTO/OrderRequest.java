package com.e_cmmerce.Order_Service.model.dto.requsetDTO;

import com.e_cmmerce.Order_Service.model.enums.PaymentMethod;
import jakarta.validation.constraints.Positive;
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
public class OrderRequest {

    private String customerId;
    private List<ProductPurchaseReq> products;
    @Positive(message = "Order amount should be posative ")
    private Double totalAmount;
    private PaymentMethod paymentMethod;
    private String reference;
    private LocalDateTime createdAt;


}
