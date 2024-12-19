package com.example.Product_Service.service;

import com.example.Product_Service.model.dto.requset.ProductPurchaseReq;
import com.example.Product_Service.model.dto.requset.ProductUpdateRequest;
import com.example.Product_Service.model.dto.response.CategoryResponse;
import com.example.Product_Service.model.dto.response.ProductPurchaseResponse;
import com.example.Product_Service.model.dto.requset.ProductReqDto;
import com.example.Product_Service.model.dto.response.ProductResponse;
import com.example.Product_Service.model.entity.Category;
import com.example.Product_Service.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    public ProductResponse createProduct(ProductReqDto reqDto);
    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseReq> purchaseReq);
    public  ProductResponse updateProduct(String id, ProductUpdateRequest dto );
    public ProductResponse getById(String id) ;
    public List<ProductPurchaseResponse> findPurchaseProductByIdInOrder(List<String> productIds);
    public List<ProductResponse>searchProductsName(String name);
    public List<ProductResponse> getAllProduct();
    public ProductResponse SoftDelete(String id);
    List<ProductResponse> findProductsByCategoryId(String categoryId);
    public ProductResponse searchByCategory(String categoryId );
    public Page<ProductResponse> getPaginatedProducts(int page, int size) ;
    List<ProductResponse> findByPriceBetween(Double minPrice, Double maxPrice);


}
