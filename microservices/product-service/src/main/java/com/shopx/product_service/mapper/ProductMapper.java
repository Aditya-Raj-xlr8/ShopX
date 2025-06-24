package com.shopx.product_service.mapper;

import com.shopx.product_service.dto.ProductRequest;
import com.shopx.product_service.dto.ProductResponse;
import com.shopx.product_service.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toProductResponse(Product product);

    Product toProduct(ProductRequest productRequest);
}
