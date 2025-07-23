package com.stockflow.inventorytask.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.inventorytask.dto.ProductDto;
import com.stockflow.inventorytask.model.Product;
import com.stockflow.inventorytask.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product create(@RequestBody ProductDto dto) {
        return productService.addProduct(dto);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }
}

