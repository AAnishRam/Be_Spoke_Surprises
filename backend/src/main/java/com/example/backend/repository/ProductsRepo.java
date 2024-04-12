package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.model.Products;

public interface ProductsRepo extends JpaRepository<Products,Integer>{
 
    @Query(value = "select p from Products p where p.price <= :price order by p.price")
    public List<Products> filterByprice(int price);
}
