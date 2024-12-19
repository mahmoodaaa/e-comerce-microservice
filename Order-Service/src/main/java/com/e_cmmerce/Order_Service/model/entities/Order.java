package com.e_cmmerce.Order_Service.model.entities;

import com.e_cmmerce.Order_Service.model.enums.OrderStatus;
import com.e_cmmerce.Order_Service.model.enums.PaymentMethod;
import com.e_cmmerce.Order_Service.model.enums.ValidEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "Customer ID is required.")
    private String customerId;
    @NotEmpty(message = "Order must have at least one order line.")
    private List<@Valid OrderLine> orderLine =new ArrayList<>() ;
    @ValidEnum(value = OrderStatus.class, message = "Invalid order status.")
    private OrderStatus orderStatus ;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedDate;
}
