package com.example.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "canalog-service",
        url = "http://localhost:8081"
)

public interface CatalogClient {
    @GetMapping("/products/{id}")
    String getProductById(@PathVariable("id") Long id);
}
