package com.example.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "catalog service", url = "http://localhost:8081")
public interface CatalogClient
{
    @GetMapping("products/{id}")
    String getProductByID(@PathVariable("id") Long id);
}
