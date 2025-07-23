package com.stockflow.inventorytask.service;

import java.util.List;

import com.stockflow.inventorytask.dto.WarehouseDto;
import com.stockflow.inventorytask.model.Warehouse;

public interface WarehouseService {
    Warehouse addWarehouse(WarehouseDto dto);
    List<Warehouse> getAllWarehouses();
}

