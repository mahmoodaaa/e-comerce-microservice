package com.e_cmmerce.Order_Service.model.dto.requsetDTO;

import com.e_cmmerce.Order_Service.model.entities.OrderLine;
import com.e_cmmerce.Order_Service.model.enums.OrderStatus;
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
    private PaymentMethod paymentMethod;
    private OrderStatus orderStatus ;
    private List<ProductPurchaseReq> products;



}
