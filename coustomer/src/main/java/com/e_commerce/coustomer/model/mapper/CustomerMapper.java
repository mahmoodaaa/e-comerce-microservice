package com.e_commerce.coustomer.model.mapper;

import com.e_commerce.coustomer.model.dto.CustomerReqDto;
import com.e_commerce.coustomer.model.dto.CustomerResponse;
import com.e_commerce.coustomer.model.entity.Customer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerMapper {

    public Customer toEntity(CustomerReqDto dto){
        if(dto==null){
            return null;
        }
        return Customer.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .build();
    }

    public  CustomerResponse toResponse(Customer customer){
        if(customer==null) {
            return null;
        }
        return CustomerResponse.builder()
                .id(customer.getId())
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .build();
    }
}



