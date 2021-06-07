package com.parkhuiwo0.cqrs.ProductService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/v1/products")
public class ProductController {

    @GetMapping
    public String getMethod() {
        return "products get!";
    }
}
