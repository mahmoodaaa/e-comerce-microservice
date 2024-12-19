package com.example.Product_Service.model.dto.requset;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateRequest {
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private String categoryId;


}
