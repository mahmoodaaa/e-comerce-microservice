package com.example.Product_Service.service;

import com.example.Product_Service.model.dto.requset.ProductPurchaseReq;
import com.example.Product_Service.model.dto.response.ProductPurchaseResponse;
import com.example.Product_Service.model.dto.requset.ProductReqDto;
import com.example.Product_Service.model.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    public ProductResponse createProduct(ProductReqDto reqDto);
    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseReq> purchaseReq);
    public  ProductResponse updateProduct(String id, ProductReqDto dto );
    public ProductResponse getById(String id) ;
    public List<ProductPurchaseResponse> findPurchaseProductByIdInOrder(List<String> productIds);
    public List<ProductResponse>searchProductsName(String name);
    public List<ProductResponse> getAllProduct();
    public ProductResponse SoftDelete(String id);





}
