package com.parkhuiwo0.cqrs.ProductService.controller;

import com.parkhuiwo0.cqrs.ProductService.command.CreateProductCommand;
import com.parkhuiwo0.cqrs.ProductService.domain.request.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/apis/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final Environment env;
    private final CommandGateway commandGateway;

    @GetMapping
    public String getMethod() {
        return "products get!" + env.getProperty("local.server.port");
    }

    @PostMapping
    public String createProduct(@RequestBody CreateProductRequest request) {

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .title(request.getTitle())
                .productId(UUID.randomUUID().toString())
                .build();

        String returnValue;

        try {
            returnValue = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception e) {
            returnValue = e.getLocalizedMessage();
        }


        return "product created ! " + request.getTitle();
    }
}
