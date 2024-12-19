package com.example.Product_Service.model.dto.requset;

import com.example.Product_Service.enums.ProductStatus;
import com.example.Product_Service.model.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductReqDto {
    @NotBlank(message = "Product name is required.")
    private String name;
    private String description;
    @NotNull(message = "Stock is required.")
    @PositiveOrZero(message = "Stock must be zero or a positive value.")
    private Double stock;

    @NotNull(message = "Price is required.")
    @Positive(message = "Price must be greater than zero.")
    private Double price;
    private String categoryId;
    private ProductStatus productStatus = ProductStatus.ACTIVE;

}
