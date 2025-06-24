package com.shopx.product_service.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse (UUID id,
                               String name,
                               String description,
                               BigDecimal price,
                               Integer quantity,
                               String countryOfOrigin) {
}
