package com.microservice.product_service.service;

import com.microservice.product_service.dto.clientrequest.ProductRequest;
import com.microservice.product_service.dto.clientresponse.ProductResponse;
import com.microservice.product_service.mapper.ProductMapper;
import com.microservice.product_service.model.Product;
import com.microservice.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // no need to make constructor to initialize mapper or repository
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public void addProduct(ProductRequest productRequest) {
//        Product product = Product.builder()
//                .name(productRequest.getName())
//                        .description(productRequest.getDescription())
//                                .price(productRequest.getPrice()).build();
        Product product = productMapper.toEntity(productRequest);
        productRepository.save(product);
    }

    public List<ProductResponse> viewProducts() {
        List<Product> products= productRepository.findAll();
        return productMapper.toResponses(products);
    }
}
