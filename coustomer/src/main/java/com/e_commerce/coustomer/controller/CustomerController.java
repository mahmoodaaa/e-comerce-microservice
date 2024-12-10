package com.e_commerce.coustomer.controller;

import com.e_commerce.coustomer.error.RecordNotFoundExciption;
import com.e_commerce.coustomer.model.dto.CustomerReqDto;
import com.e_commerce.coustomer.model.dto.CustomerResponse;
import com.e_commerce.coustomer.model.dto.ProductPurchaseResponse;
import com.e_commerce.coustomer.model.dto.ProductResponse;
import com.e_commerce.coustomer.model.entity.Customer;
import com.e_commerce.coustomer.service.CustomerService;
import com.e_commerce.coustomer.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductServiceImpl productService;


    @PostMapping("/add-customer")
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerReqDto reqDto){

        return ResponseEntity.ok(customerService.addCustomer(reqDto));
    }
    @PutMapping("/update")
    public  ResponseEntity<CustomerResponse> update(@PathVariable String id, @RequestBody CustomerReqDto dto ){

        return ResponseEntity.ok(customerService.updateProduct(id,dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findByCustomerId(@PathVariable String id) {
        return ResponseEntity.ok(customerService.getById(id));

    }
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }
    @DeleteMapping("/soft")
    public ResponseEntity<CustomerResponse> SoftDelete(@PathVariable String id){
        return ResponseEntity.ok(customerService.SoftDelete(id));

    }
    @GetMapping("/get-purchase/{id}")
    public ResponseEntity<List<ProductPurchaseResponse>> getPurchaseProduct(@PathVariable List<String> id){

        return this.productService.getPurchaseProduct(id);
    }

    @PostMapping("/get-ids")
    public ResponseEntity<List<CustomerResponse>> getCustomersByIds(@RequestBody List<String> customerIds){

        if (customerIds == null || customerIds.isEmpty()) {
            throw new RecordNotFoundExciption("Customer IDs list cannot be null or empty");
        }
        return ResponseEntity.ok(customerService.getCustomersByIds(customerIds));

    }

    @GetMapping("/get-product")
    public ResponseEntity<List<ProductResponse>> getAllProduct(){

        return ResponseEntity.ok(productService.getAllProduct().getBody());
    }

}
