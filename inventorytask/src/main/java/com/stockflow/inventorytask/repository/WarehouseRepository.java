package com.stockflow.inventorytask.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.stockflow.inventorytask.model.Warehouse;


public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
	
	

}
