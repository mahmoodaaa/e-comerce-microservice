package com.e_commerce.coustomer.service;

import com.e_commerce.coustomer.model.dto.ProductPurchaseResponse;
import com.e_commerce.coustomer.model.dto.ProductResponse;
import com.e_commerce.coustomer.proxy.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class ProductServiceImpl {
    @Autowired
    private ProductProxy productProxy;

    public ResponseEntity<List<ProductPurchaseResponse>> getPurchaseProduct( List<String> id){

        return this.productProxy.findPurchaseProductByIdInOrder(id);
    }

    public ResponseEntity<List<ProductResponse>> getAllProduct(){

        return this.productProxy.getAllProduct();

    }

}
