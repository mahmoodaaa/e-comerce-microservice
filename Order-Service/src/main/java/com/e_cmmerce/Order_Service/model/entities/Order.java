package com.e_cmmerce.Order_Service.model.entities;

import com.e_cmmerce.Order_Service.model.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String reference;
    private Double totalAmount;
    private PaymentMethod paymentMethod;
    private String customerId;
    private List<OrderLine> orderLine ;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedDate;
}
