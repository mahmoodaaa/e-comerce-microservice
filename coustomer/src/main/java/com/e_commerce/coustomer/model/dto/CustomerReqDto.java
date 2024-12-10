package com.e_commerce.coustomer.model.dto;

import com.e_commerce.coustomer.model.entity.Address;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerReqDto {
    @NotNull(message = "customer  firstName not  required")
    private String firstname;
    @NotNull(message = "customer lastName not  required")
    private String lastname;
    @NotNull(message = "customer email not  required")
    private String email;
    private Address address;

}
