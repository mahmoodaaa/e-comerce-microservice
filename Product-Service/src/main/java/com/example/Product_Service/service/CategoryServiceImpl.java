package com.example.Product_Service.service;

import com.example.Product_Service.error.RecordNotFoundExciption;
import com.example.Product_Service.model.dto.requset.CategoryReqDto;
import com.example.Product_Service.model.dto.requset.ProductReqDto;
import com.example.Product_Service.model.dto.response.CategoryResponse;
import com.example.Product_Service.model.entity.Category;
import com.example.Product_Service.model.mapper.CategoryMapper;
import com.example.Product_Service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryResponse addCategory(CategoryReqDto reqDto){
      try {
          Category category = categoryMapper.toEntity(reqDto);
        Category save = categoryRepository.save(category);
        return categoryMapper.toResponse(save);
    }
 catch (
    NoSuchElementException ex){
        throw new RecordNotFoundExciption(String.format("can not add product on database"));
    }
    }

    public List<CategoryResponse> getAll(){

        return categoryRepository.findAll().stream()
                .map(categoryMapper::toResponse).toList();
    }




}
