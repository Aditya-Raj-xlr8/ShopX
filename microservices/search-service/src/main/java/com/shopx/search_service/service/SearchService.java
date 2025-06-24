package com.shopx.search_service.service;

import com.shopx.search_service.dto.Product;

import java.util.List;

public interface SearchService {
    public List<Product> getProductsByName(String productName);
}
