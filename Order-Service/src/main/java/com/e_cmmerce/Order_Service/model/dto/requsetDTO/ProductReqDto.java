package com.e_cmmerce.Order_Service.model.dto.requsetDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductReqDto {
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private String categoryId;


}
