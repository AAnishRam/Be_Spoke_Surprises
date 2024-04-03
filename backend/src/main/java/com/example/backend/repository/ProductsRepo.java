package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Products;

public interface ProductsRepo extends JpaRepository<Products,Integer>{
    
}
