package com.shopx.search_service.service;

import com.shopx.search_service.client.ProductClient;
import com.shopx.search_service.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final ProductClient productClient;

    public List<Product> getProductsByName(String productName) {
       try{
           return productClient.getProductsByName(productName);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

}
