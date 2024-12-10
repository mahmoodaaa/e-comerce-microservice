package com.e_cmmerce.Order_Service.proxy;

import com.e_cmmerce.Order_Service.model.dto.Response.ProductPurchaseResponse;
import com.e_cmmerce.Order_Service.model.dto.Response.ProductResponse;
import com.e_cmmerce.Order_Service.model.dto.requsetDTO.ProductPurchaseReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "Product-Service")
public interface ProductProxy {
    @GetMapping("/api/products/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id);
    @PostMapping("/api/products/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(@RequestBody List<ProductPurchaseReq> purchaseReq);
    @GetMapping("/getPurchase/{id}")
    public ResponseEntity<List<ProductPurchaseResponse>> findPurchaseProductByIdInOrder(@PathVariable List<String> id) ;
    }
