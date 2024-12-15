package com.e_cmmerce.Order_Service.model.entities;

import com.e_cmmerce.Order_Service.model.enums.OrderStatus;
import com.e_cmmerce.Order_Service.model.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private List<OrderLine> orderLine =new ArrayList<>() ;
    private OrderStatus orderStatus ;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedDate;
}
