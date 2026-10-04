package com.example.orderservice.service;

import com.example.orderservice.client.CatalogClient;
import com.example.orderservice.model.PurchaseOrder;
import com.example.orderservice.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {
    private final PurchaseOrderRepository repository;
    private final CatalogClient catalogClient;

    public PurchaseOrderService(PurchaseOrderRepository repository, CatalogClient catalogClient) {
        this.repository = repository;
        this.catalogClient = catalogClient;
    }

    public List<PurchaseOrder> getAll() {
        return repository.findAll();
    }

    public PurchaseOrder create(PurchaseOrder order) {
        order.setId(null);
        return repository.save(order);
    }

    public String testCatalogConnection(Long productId) {
        return catalogClient.getProductById(productId);
    }
}