package com.example.Product_Service.controller;

import com.example.Product_Service.model.dto.requset.ProductPurchaseReq;
import com.example.Product_Service.model.dto.response.ProductPurchaseResponse;
import com.example.Product_Service.model.dto.requset.ProductReqDto;
import com.example.Product_Service.model.dto.response.ProductResponse;
import com.example.Product_Service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

   @Autowired
   private ProductService productService;
    @PostMapping("/add")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductReqDto reqDto){
    return ResponseEntity.ok(productService.createProduct(reqDto));
    }
    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>>purchaseProduct(@RequestBody List<ProductPurchaseReq> purchaseReq){
        return ResponseEntity.ok(productService.purchaseProduct(purchaseReq));
    }
    @PutMapping
    public  ResponseEntity<ProductResponse> updateProduct(String id, ProductReqDto dto ){
        return ResponseEntity.ok(productService.updateProduct(id,dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
           return ResponseEntity.ok(productService.getById(id));
    }
    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>>searchProductsName(@RequestParam String name){
        return ResponseEntity.ok(productService.searchProductsName(name));

    }
    @GetMapping("/getPurchase/{id}")
    public ResponseEntity<List<ProductPurchaseResponse>> findPurchaseProductByIdInOrder(@PathVariable List<String> id){
        return ResponseEntity.ok(productService.findPurchaseProductByIdInOrder(id));

    }
    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @DeleteMapping
    public ResponseEntity<ProductResponse> softDelete(@PathVariable String id){

        return ResponseEntity.ok(productService.SoftDelete(id));
    }
}