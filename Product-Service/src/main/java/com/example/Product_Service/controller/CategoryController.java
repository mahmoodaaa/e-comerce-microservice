package com.example.Product_Service.controller;

import com.example.Product_Service.model.dto.requset.CategoryReqDto;
import com.example.Product_Service.model.dto.requset.ProductReqDto;
import com.example.Product_Service.model.dto.response.CategoryResponse;
import com.example.Product_Service.model.dto.response.ProductResponse;
import com.example.Product_Service.service.CategoryService;
import com.example.Product_Service.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/add")
    public ResponseEntity<CategoryResponse> createProduct(@RequestBody CategoryReqDto reqDto) {
        return ResponseEntity.ok(categoryService.addCategory(reqDto));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll(){
        return ResponseEntity.ok(categoryService.getAll());
}
}
