package com.stockflow.inventorytask.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockflow.inventorytask.dto.LowStockAlertDTO;
import com.stockflow.inventorytask.repository.InventoryRepository;

@Service
public class AlertService {

	
    private final InventoryRepository inventoryRepository;

    public AlertService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<LowStockAlertDTO> getLowStockAlerts(Long companyId) {
        return inventoryRepository.getLowStockAlerts(companyId);
    }
}

