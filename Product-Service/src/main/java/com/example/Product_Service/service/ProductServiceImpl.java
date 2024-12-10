package com.example.Product_Service.service;

import com.example.Product_Service.enums.ProductStatus;
import com.example.Product_Service.error.RecordNotFoundExciption;
import com.example.Product_Service.model.dto.requset.ProductPurchaseReq;
import com.example.Product_Service.model.dto.response.ProductPurchaseResponse;
import com.example.Product_Service.model.dto.requset.ProductReqDto;
import com.example.Product_Service.model.dto.response.ProductResponse;
import com.example.Product_Service.model.entity.Category;
import com.example.Product_Service.model.entity.Product;
import com.example.Product_Service.model.mapper.ProductMapper;
import com.example.Product_Service.repository.CategoryRepository;
import com.example.Product_Service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public ProductResponse createProduct(ProductReqDto reqDto){
        try {
            Category category = categoryRepository.findById(reqDto.getCategoryId())
                    .orElseThrow(()-> new RecordNotFoundExciption("the id category not found"));
            Product product = productMapper.toEntity(reqDto,category);
            Product save = productRepository.save(product);
            return productMapper.toResponse(save);
        }
        catch (NoSuchElementException ex){
            throw new RecordNotFoundExciption(String.format("can not add product on database"));
        }
    }
    public List<ProductPurchaseResponse>purchaseProduct(List<ProductPurchaseReq> purchaseReq){

           List<String>productsId = purchaseReq.stream()
                   .map(productPurchaseReq -> productPurchaseReq.getId()).toList();

            List<Product>storedProducts = productRepository.findAllByIdInOrderById(productsId);
           if(productsId.size()!=storedProducts.size()){

               throw new RecordNotFoundExciption("One or more product doesn't exits");
           }
        // Sort the request list by product ID
        List<ProductPurchaseReq> sortedRequest = purchaseReq
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseReq::getId))
                .toList();

        // Prepare the response list
        List<ProductPurchaseResponse> purchasedProducts = new ArrayList<>();
        for (int i = 0; i < storedProducts.size(); i++) {
            Product product = storedProducts.get(i);
            ProductPurchaseReq productRequest = sortedRequest.get(i);

            // Check stock availability
            if (product.getStock() < productRequest.getQuantity()) {
                throw new RecordNotFoundExciption(
                        "Insufficient stock quantity for product with ID: " + productRequest.getId()
                );
            }
            // Deduct the requested quantity
            Double newAvailableQuantity = product.getStock() - productRequest.getQuantity();
            product.setStock(newAvailableQuantity);

            // Save the updated product
            productRepository.save(product);

            // Map to response
            purchasedProducts.add(
                    productMapper.purchaseResponse(product, productRequest.getQuantity())
            );
        }
        return purchasedProducts;
    }

    public ProductResponse updateProduct(String id, ProductReqDto dto) {
        Product products = productRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundExciption("the id not found "));
        products.setName(dto.getName());
        products.setDescription(dto.getDescription());
        products.setPrice(dto.getPrice());

        return productMapper.toResponse(productRepository.save(products));
    }
    public ProductResponse getById(String id) {
        return productRepository.findById(id)
                .filter(product -> product.getProductStatus() != ProductStatus.DELETED)
                .map(productMapper::toResponse)
                .orElseThrow(() -> new RecordNotFoundExciption(
                        "product not found or is deleted"));
    }

    @Override
    public List<ProductPurchaseResponse> findPurchaseProductByIdInOrder(List<String> productIds) {
        List<Product> storedProducts = productRepository.findByIdInOrderById(productIds);

        if (storedProducts.isEmpty()) {
            throw new RecordNotFoundExciption("No products found with the given IDs.");
        }
        List<ProductPurchaseResponse> purchasedProducts = storedProducts.stream()
                .map((Product product) -> productMapper.toProductPurchaseResponse(product))  // Mapping using the mapper
                .collect(Collectors.toList());

        return purchasedProducts;

    }
    public List<ProductResponse>searchProductsName(String name){

        return productRepository.findByNameContainingIgnoreCase(name).stream()
                .map(productMapper::toResponse).collect(Collectors.toList());
    }

    public List<ProductResponse> getAllProduct() {

        return productRepository.findAll()
                .stream().map(productMapper::toResponse)
                .toList();
    }

    public ProductResponse SoftDelete(String id) {
        Product products = productRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundExciption("the id not found "));
        products.setProductStatus(ProductStatus.DELETED);
        return productMapper.toResponse(productRepository.save(products));

    }
}