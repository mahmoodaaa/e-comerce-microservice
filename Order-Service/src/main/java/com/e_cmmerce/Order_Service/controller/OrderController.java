package com.e_cmmerce.Order_Service.controller;

import com.e_cmmerce.Order_Service.model.dto.Response.CustomerResponse;
import com.e_cmmerce.Order_Service.model.dto.Response.OrderResponse;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.OrderRequest;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.UpdatePaymentRequest;
import com.e_cmmerce.Order_Service.model.enums.PaymentMethod;
import com.e_cmmerce.Order_Service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/add-order")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.createOrder(orderRequest));
    }
    @PutMapping("/update")
    public ResponseEntity<OrderResponse> updatePaymentStatus(String id, UpdatePaymentRequest paymentMethod) {

        return ResponseEntity.ok(orderService.updatePaymentStatus(id,paymentMethod));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderId(@PathVariable String id) {
        return ResponseEntity.ok(orderService.getOrderId(id));
    }
    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {

        return ResponseEntity.ok(orderService.getAllOrders());
    }
      @PostMapping("/get-ids")
     public ResponseEntity<List<CustomerResponse>> getCustomersByIds(@RequestBody List<String> customerIds){
        return ResponseEntity.ok(orderService.getCustomersByIds(customerIds).getBody());

    }


}
