package com.parkhuiwo0.cqrs.ProductService.domain.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequest {

    private String title;
    private BigDecimal price;
    private Integer quantity;
}
