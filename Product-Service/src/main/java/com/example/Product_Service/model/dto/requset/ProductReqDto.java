package com.example.Product_Service.model.dto.requset;

import com.example.Product_Service.enums.ProductStatus;
import com.example.Product_Service.model.entity.Category;
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
    private ProductStatus productStatus = ProductStatus.ACTIVE;

}
