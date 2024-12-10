package com.e_cmmerce.Order_Service.proxy;

import com.e_cmmerce.Order_Service.model.dto.Response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "CUSTOMER-SERVICE" )
public interface CustomerProxy {


    @GetMapping("/api/customers/{id}")
    public Optional<CustomerResponse> findByCustomerId(@PathVariable String id);

    @PostMapping("/api/customers/get-ids")
    public ResponseEntity<List<CustomerResponse>> getCustomersByIds(@RequestBody List<String> customerIds);

}
