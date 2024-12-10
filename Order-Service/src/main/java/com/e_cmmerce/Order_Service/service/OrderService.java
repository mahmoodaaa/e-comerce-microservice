package com.e_cmmerce.Order_Service.service;

import com.e_cmmerce.Order_Service.model.dto.Response.CustomerResponse;
import com.e_cmmerce.Order_Service.model.dto.Response.OrderResponse;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.OrderRequest;
import com.e_cmmerce.Order_Service.model.enums.PaymentMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    public OrderResponse createOrder(OrderRequest request);
    public OrderResponse updatePaymentStatus(String id, PaymentMethod paymentMethod);
    public List<OrderResponse> getAllOrders();
    public OrderResponse getOrderId(String id);
    public ResponseEntity<List<CustomerResponse>> getCustomersByIds(List<String> customerIds);

}
