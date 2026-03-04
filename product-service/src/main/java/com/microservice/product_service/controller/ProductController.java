package com.microservice.product_service.controller;

import com.microservice.product_service.dto.clientrequest.ProductRequest;
import com.microservice.product_service.dto.clientresponse.ProductResponse;
import com.microservice.product_service.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(@RequestBody ProductRequest productRequest){
        productService.addProduct(productRequest);
    }

    @GetMapping
    public List<ProductResponse> viewProducts(){
        return productService.viewProducts();
    }
}
