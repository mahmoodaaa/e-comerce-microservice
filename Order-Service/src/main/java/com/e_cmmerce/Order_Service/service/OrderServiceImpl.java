package com.e_cmmerce.Order_Service.service;

import com.e_cmmerce.Order_Service.error.RecordNotFoundExciption;
import com.e_cmmerce.Order_Service.model.dto.Response.CustomerResponse;
import com.e_cmmerce.Order_Service.model.dto.Response.OrderResponse;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.OrderRequest;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.ProductPurchaseReq;
import com.e_cmmerce.Order_Service.model.entities.OrderLine;
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
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.NoSuchElementException;
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
    private OrderMapper orderMapper;
    @Autowired
    private CustomerProxy customerProxy;
    @Autowired
    private ProductProxy productProxy;
    public OrderResponse createOrder(OrderRequest orderRequest){
        List<ProductPurchaseReq> products = orderRequest.getProducts();
        log.debug("Requesting purchase for products: {}", products);


        var customer = this.customerProxy.findByCustomerId(orderRequest.getCustomerId())
                .orElseThrow(()-> new RecordNotFoundExciption("the customer id not found"));
        try {
            var purchasedProduct = this.productProxy.purchaseProduct(orderRequest.getProducts());

        }catch (NoSuchElementException ex){
            throw new RecordNotFoundExciption(String.format("Failed to purchase products. One or more products do not exist"));
        }
            Order order = orderMapper.toEntity(orderRequest);
            Order save = orderRepository.save(order);

       List<OrderLine>orderLines = orderRequest.getProducts().stream()
               .map(productPurchaseReq -> OrderLine.builder()
                       .order(order)
                       .id(productPurchaseReq.getProductId())
                       .quantity(productPurchaseReq.getQuantity())
                       .build()).toList();

                 orderLineRepository.saveAll(orderLines);
                 order.setOrderLine(orderLines);
                 orderRepository.save(order);

                 return orderMapper.toResponse(order);
    }
    @Override
    public OrderResponse getOrderId(String id) {
        return orderRepository.findById(id)
                .map(orderMapper::toResponse)
                .orElseThrow(()->new RecordNotFoundExciption("the Order id not found"));
    }
    public OrderResponse updatePaymentStatus(String id, PaymentMethod paymentMethod) {
        Order order = orderRepository.findById(id).orElseThrow(()->
                new RecordNotFoundExciption("the customer id not found"));
        order.setPaymentMethod(paymentMethod);
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
