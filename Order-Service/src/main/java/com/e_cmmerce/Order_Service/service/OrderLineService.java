package com.e_cmmerce.Order_Service.service;

import com.e_cmmerce.Order_Service.model.dto.Response.OrderLineResponse;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.OrderLineRequest;

import java.util.List;

public interface OrderLineService {
    public OrderLineResponse saveOrderLine(OrderLineRequest request) ;

    public List<OrderLineResponse> findAllByOrderId(String orderId);

}
