package com.stockflow.inventorytask.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockflow.inventorytask.dto.InventoryDto;
import com.stockflow.inventorytask.model.Inventory;
import com.stockflow.inventorytask.model.Product;
import com.stockflow.inventorytask.model.Warehouse;
import com.stockflow.inventorytask.repository.InventoryRepository;
import com.stockflow.inventorytask.repository.ProductRepository;
import com.stockflow.inventorytask.repository.WarehouseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepo;
    private final ProductRepository productRepo;
    private final WarehouseRepository warehouseRepo;

    @Override
    public Inventory addInventory(InventoryDto dto) {
        Product product = productRepo.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Warehouse warehouse = warehouseRepo.findById(dto.getWarehouseId())
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));

        Inventory inventory = new Inventory();
        inventory.setProduct(product);
        inventory.setWarehouse(warehouse);
        inventory.setQuantity(dto.getQuantity());

        return inventoryRepo.save(inventory);
    }

    @Override
    public List<Inventory> getInventoryByProduct(Long productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return inventoryRepo.findByProduct(product);
    }

    @Override
    public List<Inventory> getInventoryByWarehouse(Long warehouseId) {
        Warehouse warehouse = warehouseRepo.findById(warehouseId)
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));
        return inventoryRepo.findByWareHouse(warehouse);
    }
}

