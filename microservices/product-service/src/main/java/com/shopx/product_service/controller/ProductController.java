package com.shopx.product_service.controller;

import com.shopx.product_service.dto.ProductRequest;
import com.shopx.product_service.dto.ProductResponse;
import com.shopx.product_service.dto.ProductUpdateRequest;
import com.shopx.product_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse addNewProduct(@RequestBody @Valid ProductRequest productRequest) {
       return productService.addProduct(productRequest);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable UUID productId) {
        productService.deleteProduct(productId);
    }

    @PatchMapping("/updateProduct/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse updateProduct(@PathVariable UUID productId,
                                         @RequestBody @Valid ProductUpdateRequest productRequest) {
        return productService.updateProduct(productId, productRequest);
    }

    @GetMapping("/allProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/getProductsByName")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProductsByName(@RequestParam String name) {
        return productService.getProductsByName(name);
    }

}
