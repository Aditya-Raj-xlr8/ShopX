package com.shopx.search_service.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String countryOfOrigin;
}
