package com.example.Product_Service.model.entity;

import com.example.Product_Service.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private Category category;
    private ProductStatus productStatus = ProductStatus.ACTIVE ;


}
