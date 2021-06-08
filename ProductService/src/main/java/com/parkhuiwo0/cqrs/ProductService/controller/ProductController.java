package com.parkhuiwo0.cqrs.ProductService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final Environment env;

    @GetMapping
    public String getMethod() {
        return "products get!" + env.getProperty("local.server.port");
    }
}
