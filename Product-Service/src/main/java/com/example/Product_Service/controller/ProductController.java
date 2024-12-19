package com.example.Product_Service.controller;

import com.example.Product_Service.model.dto.requset.ProductPurchaseReq;
import com.example.Product_Service.model.dto.requset.ProductUpdateRequest;
import com.example.Product_Service.model.dto.response.ProductPurchaseResponse;
import com.example.Product_Service.model.dto.requset.ProductReqDto;
import com.example.Product_Service.model.dto.response.ProductResponse;
import com.example.Product_Service.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

   @Autowired
   private ProductService productService;
    @PostMapping("/add")
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductReqDto reqDto){
    return ResponseEntity.ok(productService.createProduct(reqDto));
    }
    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>>purchaseProduct(@RequestBody List<ProductPurchaseReq> purchaseReq){
        return ResponseEntity.ok(productService.purchaseProduct(purchaseReq));
    }
    @PutMapping("/{id}")
    public  ResponseEntity<ProductResponse> updateProduct(@PathVariable String id,@RequestBody ProductUpdateRequest dto ){
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
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductResponse>> getProductsByCategory(@PathVariable String categoryId) {
        List<ProductResponse> products = productService.findProductsByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }


    @GetMapping("/{categoryId}")
    public ResponseEntity<ProductResponse> searchByCategory( @PathVariable String categoryId){

        return ResponseEntity.ok(productService.searchByCategory(categoryId));

    }

    @DeleteMapping
    public ResponseEntity<ProductResponse> softDelete(@PathVariable String id){

        return ResponseEntity.ok(productService.SoftDelete(id));
    }
    @GetMapping("/paginated")
    public ResponseEntity<Page<ProductResponse>> getPaginatedProducts(@RequestParam int page, @RequestParam int size) {

        return ResponseEntity.ok(productService.getPaginatedProducts(page,size));
    }
   @GetMapping("/price-range")
    public ResponseEntity<List<ProductResponse>> findByPriceBetween(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
         return ResponseEntity.ok(productService.findByPriceBetween(minPrice,maxPrice));

    }
}