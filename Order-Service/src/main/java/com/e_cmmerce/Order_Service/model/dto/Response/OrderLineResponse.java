package com.e_cmmerce.Order_Service.model.dto.Response;

import com.e_cmmerce.Order_Service.model.entities.OrderLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineResponse {
    private String id;
    private String productId;
    private Double quantity;
    private Double price;
}
