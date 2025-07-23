package com.stockflow.inventorytask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LowStockAlertDTO {
    private String productName;
    private String warehouseName;
    private int currentStock;
    private int threshold;
    private int reorderQuantity;
    private String supplierName;
    private String supplierEmail;
    private String supplierPhone;
}

