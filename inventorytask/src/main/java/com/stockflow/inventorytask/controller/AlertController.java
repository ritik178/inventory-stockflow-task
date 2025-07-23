package com.stockflow.inventorytask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.inventorytask.dto.LowStockAlertDTO;
import com.stockflow.inventorytask.service.AlertService;

@RestController
@RequestMapping("/api/companies")
public class AlertController {

	
    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping("/{companyId}/alerts/low-stock")
    public ResponseEntity<List<LowStockAlertDTO>> getLowStockAlerts(@PathVariable Long companyId) {
        return ResponseEntity.ok(alertService.getLowStockAlerts(companyId));
    }
}
