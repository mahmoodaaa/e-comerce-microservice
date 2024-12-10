package com.e_commerce.coustomer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPurchaseResponse {
    private String id;
    private String name;
    private String description;
    private Double quantity;
    private Double price;
    private Double stock;
    private String categoryName;
    private String categoryId;

}
