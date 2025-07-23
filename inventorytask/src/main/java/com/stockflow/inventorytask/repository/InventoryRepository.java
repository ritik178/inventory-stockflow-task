package com.stockflow.inventorytask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stockflow.inventorytask.dto.LowStockAlertDTO;
import com.stockflow.inventorytask.model.Inventory;
import com.stockflow.inventorytask.model.Product;
import com.stockflow.inventorytask.model.Warehouse;


public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	List<Inventory> findByProduct(Product product);
	List<Inventory> findByWareHouse(Warehouse warehouse);
	
	@Query("SELECT new com.stockflow.inventorytask.dto.LowStockAlertDTO(" +
		       "p.name, " +
		       "w.name, " +
		       "i.quantity, " +
		       "p.threshold, " +
		       "p.reorderQuantity, " +
		       "s.name, " +
		       "s.email, " +
		       "s.phone) " +
		       "FROM Inventory i " +
		       "JOIN i.product p " +
		       "JOIN i.warehouse w " +
		       "JOIN ProductSupplier ps ON ps.product.id = p.id " +
		       "JOIN Supplier s ON s.id = ps.supplier.id " +
		       "WHERE p.company.id = :companyId " +
		       "AND i.quantity < p.threshold")
		List<LowStockAlertDTO> getLowStockAlerts(@Param("companyId") Long companyId);

}
