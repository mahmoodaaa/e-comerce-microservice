package com.example.Product_Service.controller;

import com.example.Product_Service.model.dto.requset.CategoryReqDto;
import com.example.Product_Service.model.dto.requset.ProductReqDto;
import com.example.Product_Service.model.dto.response.CategoryResponse;
import com.example.Product_Service.model.dto.response.ProductResponse;
import com.example.Product_Service.service.CategoryService;
import com.example.Product_Service.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/add")
    public ResponseEntity<CategoryResponse> createProduct(@RequestBody CategoryReqDto reqDto) {
        return ResponseEntity.ok(categoryService.addCategory(reqDto));

    }
}
