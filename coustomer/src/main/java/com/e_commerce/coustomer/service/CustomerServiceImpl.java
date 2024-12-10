package com.e_commerce.coustomer.service;

import com.e_commerce.coustomer.enums.CustomerStatus;
import com.e_commerce.coustomer.error.RecordNotFoundExciption;
import com.e_commerce.coustomer.model.dto.CustomerReqDto;
import com.e_commerce.coustomer.model.dto.CustomerResponse;
import com.e_commerce.coustomer.model.entity.Customer;
import com.e_commerce.coustomer.model.mapper.CustomerMapper;
import com.e_commerce.coustomer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService  {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerRepository customerRepository;


    public CustomerResponse addCustomer(CustomerReqDto reqDto){
       try {


           Customer customer = customerMapper.toEntity(reqDto);
           Customer save = customerRepository.save(customer);
           return customerMapper.toResponse(save);
       }
       catch (NoSuchElementException ex){
           throw new RecordNotFoundExciption(String.format("can not add customer on database"));
       }
    }

    public  CustomerResponse updateProduct(String id, CustomerReqDto dto ){

        Customer customer = customerRepository.findById(id).orElseThrow(()->new RecordNotFoundExciption("the id not found "));

        customer.setFirstname(dto.getFirstname());
        customer.setLastname(dto.getLastname());
        customer.setEmail(dto.getEmail());
        customer.setAddress(dto.getAddress());
        return customerMapper.toResponse(customerRepository.save(customer));
    }


    public CustomerResponse getById(String id) {

         return customerRepository.findById(id)
                 .filter(customer -> customer.getCustomerStatus() != CustomerStatus.DELETED)
                 .map(customerMapper::toResponse)
                 .orElseThrow(() -> new RecordNotFoundExciption("Customer with ID " + id + " not found."));
    }




    public List<CustomerResponse> getAll(){

        return customerRepository.findAll()
                .stream().map(customerMapper::toResponse)
                .collect(Collectors.toList());

    }


    public List<CustomerResponse> getCustomersByIds(List<String> customerIds) {
        return customerRepository.findAllByIdInOrderById(customerIds).stream()
                .map(customerMapper::toResponse).collect(Collectors.toList());
    }
    public CustomerResponse SoftDelete(String id){
       Customer customer = customerRepository.findById(id).orElseThrow(() -> new RecordNotFoundExciption("cart not found"));
       customer.setCustomerStatus(CustomerStatus.DELETED);
       Customer save  = customerRepository.save(customer);
       return customerMapper.toResponse(save);

    }




}
