package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Address;

public interface AddressRepo extends JpaRepository<Address,Integer>{
    
}
