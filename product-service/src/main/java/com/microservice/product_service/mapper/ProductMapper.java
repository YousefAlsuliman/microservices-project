package com.microservice.product_service.mapper;

import com.microservice.product_service.dto.clientrequest.ProductRequest;
import com.microservice.product_service.dto.clientresponse.ProductResponse;
import com.microservice.product_service.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // Request -> Entity (create/update input)
    @Mapping(target = "id", ignore = true)
    Product toEntity(ProductRequest request);
    List<Product> toEntities(List<ProductRequest> requests);

    // Entity -> Response (API output)
    ProductResponse toResponse(Product product);
    List<ProductResponse> toResponses(List<Product> products);
}
