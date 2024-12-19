package com.e_cmmerce.Order_Service.model.dto.requsetDTO;

import com.e_cmmerce.Order_Service.model.enums.OrderStatus;
import com.e_cmmerce.Order_Service.model.enums.PaymentMethod;
import com.e_cmmerce.Order_Service.model.enums.ValidEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchOrderRequest {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @ValidEnum(value = OrderStatus.class, message = "Invalid order status.")
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
}
