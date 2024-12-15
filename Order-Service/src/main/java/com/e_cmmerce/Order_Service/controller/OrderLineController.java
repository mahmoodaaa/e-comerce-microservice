package com.e_cmmerce.Order_Service.controller;

import com.e_cmmerce.Order_Service.model.dto.Response.OrderLineResponse;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.OrderLineRequest;
import com.e_cmmerce.Order_Service.model.entities.OrderLine;
import com.e_cmmerce.Order_Service.service.OrderLineService;
import com.e_cmmerce.Order_Service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orderLine")
public class OrderLineController {


    @Autowired
    private OrderLineService orderLineService;
    @PostMapping("/add")
    public ResponseEntity<OrderLineResponse> saveOrderLine(@RequestBody OrderLineRequest request) {
        return ResponseEntity.ok(orderLineService.saveOrderLine(request));
    }
   @GetMapping
    public ResponseEntity<List<OrderLineResponse>> findAllByOrderId(@PathVariable String orderId) {
          return ResponseEntity.ok(orderLineService.findAllByOrderId(orderId));
    }
}
