package com.example.orderservice.client;

import com.example.orderservice.client.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "canalog-service",
        url = "http://localhost:8081"
)

public interface CatalogClient {
    @GetMapping("/products/{id}")
    ProductResponse getProductById(@PathVariable("id") Long id);
}
