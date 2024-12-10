package com.example.Product_Service.service;

import com.example.Product_Service.model.dto.requset.CategoryReqDto;
import com.example.Product_Service.model.dto.response.CategoryResponse;

public interface CategoryService {

    public CategoryResponse addCategory(CategoryReqDto reqDto);

}
