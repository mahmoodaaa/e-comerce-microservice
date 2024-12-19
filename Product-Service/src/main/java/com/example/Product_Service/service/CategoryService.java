package com.example.Product_Service.service;

import com.example.Product_Service.model.dto.requset.CategoryReqDto;
import com.example.Product_Service.model.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    public CategoryResponse addCategory(CategoryReqDto reqDto);
    public List<CategoryResponse> getAll();
}
