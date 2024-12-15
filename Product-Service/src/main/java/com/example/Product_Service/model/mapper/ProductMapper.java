package com.example.Product_Service.model.mapper;

import com.example.Product_Service.model.dto.response.ProductPurchaseResponse;
import com.example.Product_Service.model.dto.requset.ProductReqDto;
import com.example.Product_Service.model.dto.response.ProductResponse;
import com.example.Product_Service.model.entity.Category;
import com.example.Product_Service.model.entity.Product;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductMapper {

    public Product toEntity(ProductReqDto dto ,Category category){
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .category(category)
                .build();
    }
    public  ProductResponse toResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .categoryDescription(product.getCategory().getDescription())
                .build();
    }
    public ProductPurchaseResponse purchaseResponse(Product product , Double quantity){
                 return ProductPurchaseResponse.builder()
                         .id(product.getId())
                         .name(product.getName())
                         .description(product.getDescription())
                         .price(product.getPrice())
                         .stock(product.getStock())
                         .quantity(quantity)
                         .categoryId(product.getCategory().getId())
                         .categoryName(product.getCategory().getName())
                         .build();

    }
    public ProductPurchaseResponse toProductPurchaseResponse(Product product) {
        if (product == null) {
            return null;
        }

        return ProductPurchaseResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .stock(product.getStock())
                .price(product.getPrice())
                .categoryName(product.getCategory().getName())
                .categoryId(product.getCategory().getId())
                .build();
    }
}



