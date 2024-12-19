package com.example.Product_Service.model.dto.response;

import com.example.Product_Service.model.dto.requset.ProductReqDto;
import com.example.Product_Service.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
