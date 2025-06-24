package com.shopx.search_service.client;

import com.shopx.search_service.dto.Product;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/product")
public interface ProductClient {

    @GetExchange("getProductsByName")
    List<Product> getProductsByName(@RequestParam String name);
}
