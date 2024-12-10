package com.e_cmmerce.Order_Service.model.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private String categoryName;
    private String categoryId;
    private String categoryDescription;
}
