package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Signup;

public interface SignupRepo extends JpaRepository<Signup,Integer>{
    
}
