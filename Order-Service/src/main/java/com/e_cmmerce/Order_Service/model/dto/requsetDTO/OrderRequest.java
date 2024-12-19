package com.e_cmmerce.Order_Service.model.dto.requsetDTO;

import com.e_cmmerce.Order_Service.model.entities.OrderLine;
import com.e_cmmerce.Order_Service.model.enums.OrderStatus;
import com.e_cmmerce.Order_Service.model.enums.PaymentMethod;
import com.e_cmmerce.Order_Service.model.enums.ValidEnum;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "Customer ID is required.")
    private String customerId;
    private PaymentMethod paymentMethod;
    @ValidEnum(value = OrderStatus.class, message = "Invalid order status.")
    private OrderStatus orderStatus ;

    @NotEmpty(message = "Order must have at least one order line.")
    private List<ProductPurchaseReq> products;



}
