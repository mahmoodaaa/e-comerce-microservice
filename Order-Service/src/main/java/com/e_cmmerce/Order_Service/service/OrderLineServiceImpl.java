package com.e_cmmerce.Order_Service.service;

import com.e_cmmerce.Order_Service.model.dto.Response.OrderLineResponse;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.OrderLineRequest;
import com.e_cmmerce.Order_Service.model.entities.Order;
import com.e_cmmerce.Order_Service.model.entities.OrderLine;
import com.e_cmmerce.Order_Service.model.mapper.OrderLineMapper;
import com.e_cmmerce.Order_Service.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrderLineServiceImpl implements OrderLineService {
    @Autowired
    private OrderLineMapper orderLineMapper;
    @Autowired
    private OrderLineRepository orderLineRepository;
    @Override
    public OrderLineResponse saveOrderLine(OrderLineRequest request) {
        OrderLine orderLine = orderLineMapper.toOrderLine(request);
        OrderLine save = orderLineRepository.save(orderLine);
        return orderLineMapper.toOrderLineResponse(save);
    }
    @Override
    public List<OrderLineResponse> findAllByOrderId(String orderId) {
        return orderLineRepository.findAllByOrderId(orderId).stream()
                .map(orderLineMapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
