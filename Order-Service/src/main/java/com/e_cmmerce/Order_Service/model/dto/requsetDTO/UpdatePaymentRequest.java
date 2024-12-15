package com.e_cmmerce.Order_Service.model.dto.requsetDTO;

import com.e_cmmerce.Order_Service.model.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentRequest {
    private PaymentMethod paymentMethod;
}
