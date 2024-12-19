package com.example.Product_Service.model.mapper;

import com.example.Product_Service.model.dto.requset.CategoryReqDto;
import com.example.Product_Service.model.dto.requset.ProductReqDto;
import com.example.Product_Service.model.dto.response.CategoryResponse;
import com.example.Product_Service.model.dto.response.ProductResponse;
import com.example.Product_Service.model.entity.Category;
import com.example.Product_Service.model.entity.Product;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryMapper {


    public Category toEntity(CategoryReqDto dto){
        return Category.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }

    public CategoryResponse toResponse(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }





}
