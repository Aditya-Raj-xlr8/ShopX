package com.shopx.product_service.service;

import com.shopx.product_service.dto.ProductRequest;
import com.shopx.product_service.dto.ProductResponse;
import com.shopx.product_service.dto.ProductUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public ProductResponse addProduct(ProductRequest productRequest);
    public void deleteProduct(UUID productId);
    public ProductResponse updateProduct(UUID productId, ProductUpdateRequest productRequest);
    public List<ProductResponse> getAllProducts();
    public List<ProductResponse> getProductsByName(String name);
}
