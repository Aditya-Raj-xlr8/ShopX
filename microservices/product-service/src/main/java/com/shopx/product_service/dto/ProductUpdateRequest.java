package com.shopx.product_service.dto;

import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

public record ProductUpdateRequest(
        String name,
        String description,
        @DecimalMin(value = "0.0")
        BigDecimal price,
        @DecimalMin(value = "0")
        Integer quantity,
        String countryOfOrigin) {
}
