package com.e_commerce.coustomer.model.dto;

import com.e_commerce.coustomer.model.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
}
