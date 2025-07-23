package com.stockflow.inventorytask.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockflow.inventorytask.dto.ProductDto;
import com.stockflow.inventorytask.model.Product;
import com.stockflow.inventorytask.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;

    @Override
    public Product addProduct(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setSku(dto.getSku());
        product.setDescription(dto.getDescription());
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}

