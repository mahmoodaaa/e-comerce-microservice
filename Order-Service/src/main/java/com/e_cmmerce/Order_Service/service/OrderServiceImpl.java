package com.e_cmmerce.Order_Service.service;

import com.e_cmmerce.Order_Service.error.RecordNotFoundExciption;
import com.e_cmmerce.Order_Service.model.dto.Response.CustomerResponse;
import com.e_cmmerce.Order_Service.model.dto.Response.OrderLineResponse;
import com.e_cmmerce.Order_Service.model.dto.Response.OrderResponse;
import com.e_cmmerce.Order_Service.model.dto.Response.ProductPurchaseResponse;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.OrderLineRequest;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.OrderRequest;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.ProductPurchaseReq;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.UpdatePaymentRequest;
import com.e_cmmerce.Order_Service.model.entities.OrderLine;
import com.e_cmmerce.Order_Service.model.enums.OrderStatus;
import com.e_cmmerce.Order_Service.model.enums.PaymentMethod;
import com.e_cmmerce.Order_Service.model.mapper.OrderMapper;
import com.e_cmmerce.Order_Service.proxy.CustomerProxy;
import com.e_cmmerce.Order_Service.proxy.ProductProxy;
import com.e_cmmerce.Order_Service.repository.OrderLineRepository;
import com.e_cmmerce.Order_Service.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.e_cmmerce.Order_Service.model.entities.Order;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.context.annotation.ConfigurationClassUtils.getOrder;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderLineRepository orderLineRepository;
    @Autowired
    private  OrderLineService orderLineService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CustomerProxy customerProxy;
    @Autowired
    private ProductProxy productProxy;

    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest) {
        // Validate and purchase products
        List<ProductPurchaseReq> products = orderRequest.getProducts();
        List<ProductPurchaseResponse> purchasedProducts;
        try {
            purchasedProducts = productProxy.purchaseProduct(products).getBody();
        } catch (Exception e) {
            throw new RecordNotFoundExciption("Product purchase failed: " + e.getMessage());
        }

        // Calculate total amount
        double totalAmount = purchasedProducts.stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();

        // Create and save order
        Order order = Order.builder()
                .customerId(orderRequest.getCustomerId())
                .paymentMethod(orderRequest.getPaymentMethod())
                .orderStatus(orderRequest.getOrderStatus())
                .totalAmount(totalAmount)
                .reference(UUID.randomUUID().toString())
                .createdAt(LocalDateTime.now())
                .build();
        orderRepository.save(order);

        // Create and save order lines
        List<OrderLine> orderLines = purchasedProducts.stream()
                .map(product -> OrderLine.builder()
                        .order(order)
                        .productId(product.getProductId())
                        .quantity(product.getQuantity())
                        .price(product.getPrice())
                        .build())
                .collect(Collectors.toList());
        orderLineRepository.saveAll(orderLines);

        order.setOrderLine(orderLines);
        return OrderResponse.builder()
                .id(order.getId())
                .reference(order.getReference())
                .totalAmount(order.getTotalAmount())
                .orderLine(orderLines.stream().map(orderLine -> OrderLineResponse.builder()
                        .id(orderLine.getId())
                        .productId(orderLine.getProductId())
                        .quantity(orderLine.getQuantity())
                        .price(orderLine.getPrice())
                        .build()).collect(Collectors.toList()))
                .customerId(order.getCustomerId())
                .paymentMethod(order.getPaymentMethod())
                .orderStatus(OrderStatus.DELIVERED)
                .createdAt(order.getCreatedAt())
                .build();
    }


    @Override
    public OrderResponse getOrderId(String id) {
        return orderRepository.findById(id)
                .map(orderMapper::toResponse)
                .orElseThrow(()->new RecordNotFoundExciption("the Order id not found"));
    }
    @Override
    public OrderResponse updatePaymentStatus(String id, UpdatePaymentRequest paymentMethod) {
        Order order = orderRepository.findById(id).orElseThrow(()->
                new RecordNotFoundExciption("Order not found with ID:"));
        order.setPaymentMethod(paymentMethod.getPaymentMethod());
       return orderMapper.toResponse(orderRepository.save(order));
    }
    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toResponse).collect(Collectors.toList());
    }

    public ResponseEntity<List<CustomerResponse>> getCustomersByIds(List<String> customerIds){
         return customerProxy.getCustomersByIds(customerIds);
    }



}
