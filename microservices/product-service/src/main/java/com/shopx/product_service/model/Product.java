package com.shopx.product_service.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class Product {
    @Id
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String countryOfOrigin;
}
