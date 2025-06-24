package com.shopx.product_service.service;

import com.shopx.product_service.dto.ProductRequest;
import com.shopx.product_service.dto.ProductResponse;
import com.shopx.product_service.dto.ProductUpdateRequest;
import com.shopx.product_service.mapper.ProductMapper;
import com.shopx.product_service.model.Product;
import com.shopx.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductResponse addProduct(ProductRequest productRequest) {
      Product product = productMapper.toProduct(productRequest);
      product.setId(UUID.randomUUID());
      product = productRepository.save(product);

      log.info("Product {} is saved", product.getName());

      return productMapper.toProductResponse(product);
    }

    public void deleteProduct(UUID productId) {
        try{
            productRepository.deleteById(productId);
            log.info("Product with ID: {} has been deleted successfully", productId);
        }catch (Exception e) {
            log.error("Error deleting product with ID: {}", productId, e);
            throw new RuntimeException("Failed to delete product with ID: " + productId, e);
        }
    }

    public ProductResponse updateProduct(UUID productId, ProductUpdateRequest productRequest) {
        try{
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

            if(productRequest.name() != null) {
                product.setName(productRequest.name());
            }
            if(productRequest.description() != null) {
                product.setDescription(productRequest.description());
            }
            if(productRequest.price() != null) {
                product.setPrice(productRequest.price());
            }
            if(productRequest.countryOfOrigin() != null) {
                product.setCountryOfOrigin(productRequest.countryOfOrigin());
            }
            product = productRepository.save(product);

            log.info("Product with ID: {} has been updated successfully", productId);

            return productMapper.toProductResponse(product);
        }catch (Exception e) {
            log.error("Error updating product with ID: {}", productId, e);
            throw new RuntimeException("Failed to update product with ID: " + productId, e);
        }
    }

    public List<ProductResponse> getAllProducts() {
        try {
            List<Product> products = productRepository.findAll();

            return products.stream()
                    .map(productMapper::toProductResponse)
                    .toList();
        }catch (Exception e) {
            log.error("Error retrieving all products", e);
            throw new RuntimeException("Failed to retrieve products", e);
        }
    }

    public List<ProductResponse> getProductsByName(String name) {
        try {
            List<Product> products = productRepository.findByNameContainingIgnoreCase(name);

            return products.stream()
                    .map(productMapper::toProductResponse)
                    .toList();
        }catch (Exception e) {
            log.error("Error retrieving products by name: {}", name, e);
            throw new RuntimeException("Failed to retrieve products by name: " + name, e);
        }
    }

}
