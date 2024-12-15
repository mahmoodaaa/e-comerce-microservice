package com.e_commerce.coustomer.proxy;

import com.e_commerce.coustomer.model.dto.ProductPurchaseReq;
import com.e_commerce.coustomer.model.dto.ProductPurchaseResponse;
import com.e_commerce.coustomer.model.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "Product-Service"  )
public interface ProductProxy {


    @PostMapping("/api/products/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(@RequestBody List<ProductPurchaseReq> purchaseReq);

    @GetMapping("/api/products/getPurchase/{id}")
    public ResponseEntity<List<ProductPurchaseResponse>> findPurchaseProductByIdInOrder(@PathVariable List<String> id);

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductResponse>> getAllProduct();


}
