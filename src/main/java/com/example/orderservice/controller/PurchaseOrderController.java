package com.example.orderservice.controller;

import com.example.orderservice.model.PurchaseOrder;
import com.example.orderservice.repository.PurchaseOrderRepository;
import com.example.orderservice.service.PurchaseOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class PurchaseOrderController {
    private final PurchaseOrderService service;
    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderController(PurchaseOrderService service, PurchaseOrderRepository purchaseOrderRepository) {
        this.service = service;
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    @GetMapping
    public List<PurchaseOrder> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseOrder create(@RequestBody PurchaseOrder order) {
        return service.create(order);
    }

    @GetMapping("/test-catalog/{productId}")
    public String testCatalogConnection(@PathVariable Long productId) {
        return service.testCatalogConnection(productId);
    }
}