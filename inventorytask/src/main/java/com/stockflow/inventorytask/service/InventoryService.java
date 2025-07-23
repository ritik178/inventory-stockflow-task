package com.stockflow.inventorytask.service;

import java.util.List;

import com.stockflow.inventorytask.dto.InventoryDto;
import com.stockflow.inventorytask.model.Inventory;

public interface InventoryService {
    Inventory addInventory(InventoryDto dto);
    List<Inventory> getInventoryByProduct(Long productId);
    List<Inventory> getInventoryByWarehouse(Long warehouseId);
}

