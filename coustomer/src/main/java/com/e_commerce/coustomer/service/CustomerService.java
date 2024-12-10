package com.e_commerce.coustomer.service;


import com.e_commerce.coustomer.enums.CustomerStatus;
import com.e_commerce.coustomer.error.RecordNotFoundExciption;
import com.e_commerce.coustomer.model.dto.CustomerReqDto;
import com.e_commerce.coustomer.model.dto.CustomerResponse;
import com.e_commerce.coustomer.model.entity.Customer;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public interface CustomerService {
    public CustomerResponse addCustomer(CustomerReqDto reqDto);
    public  CustomerResponse updateProduct(String id, CustomerReqDto dto );
    public CustomerResponse getById(String id) ;
    public List<CustomerResponse> getAll();
    public List<CustomerResponse> getCustomersByIds(List<String> customerIds) ;
     public CustomerResponse SoftDelete(String id);
}
