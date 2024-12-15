package com.e_cmmerce.Order_Service.model.dto.Response;

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

}
