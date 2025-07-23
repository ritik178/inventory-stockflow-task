package com.stockflow.inventorytask.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockflow.inventorytask.dto.WarehouseDto;
import com.stockflow.inventorytask.model.Warehouse;
import com.stockflow.inventorytask.repository.WarehouseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepo;

    @Override
    public Warehouse addWarehouse(WarehouseDto dto) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(dto.getName());
        warehouse.setLocation(dto.getLocation());
        return warehouseRepo.save(warehouse);
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepo.findAll();
    }
}

