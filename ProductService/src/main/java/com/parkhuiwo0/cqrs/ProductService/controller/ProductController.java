package com.parkhuiwo0.cqrs.ProductService.controller;

import com.parkhuiwo0.cqrs.ProductService.domain.request.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final Environment env;

    @GetMapping
    public String getMethod() {
        return "products get!" + env.getProperty("local.server.port");
    }

    @PostMapping
    public String createProduct(@RequestBody CreateProductRequest request) {
        return "product created ! " + request.getTitle();
    }
}
