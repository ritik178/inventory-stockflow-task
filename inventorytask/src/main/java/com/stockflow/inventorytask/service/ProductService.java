package com.stockflow.inventorytask.service;

import java.util.List;

import com.stockflow.inventorytask.dto.ProductDto;
import com.stockflow.inventorytask.model.Product;

public interface ProductService {
    Product addProduct(ProductDto dto);
    List<Product> getAllProducts();
}
