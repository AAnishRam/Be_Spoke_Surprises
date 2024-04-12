package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Signup {
    @Id
    int userId;
    String name;
    String email;
    String password;

    @OneToOne(mappedBy = "signup", cascade = CascadeType.ALL)
    @JsonManagedReference 
    private Address address;


    public Signup() {
    }

    public Signup(int userId, String name, String email, String password, Address address) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
    

    
}
