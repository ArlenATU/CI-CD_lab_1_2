package com.example.orderservice.service;

import com.example.orderservice.model.PurchaseOrder;
import com.example.orderservice.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {
    private final PurchaseOrderRepository repository;

    public PurchaseOrderService(PurchaseOrderRepository repository) {
        this.repository = repository;
    }

    public List<PurchaseOrder> getAll() {
        return repository.findAll();
    }

    public PurchaseOrder create(PurchaseOrder order) {
        order.setId(null);
        return repository.save(order);
    }
}