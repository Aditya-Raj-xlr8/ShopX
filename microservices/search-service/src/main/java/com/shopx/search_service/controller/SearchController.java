package com.shopx.search_service.controller;

import com.shopx.search_service.dto.Product;
import com.shopx.search_service.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/searchProductsByName")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProductsByName(@RequestParam String name) {
        return searchService.getProductsByName(name);
    }

}
