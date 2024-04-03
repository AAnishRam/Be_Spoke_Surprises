package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Products;
import com.example.backend.service.ProductsService;

@RestController
public class ProductsController {
    
    @Autowired
    ProductsService ps;

    @PostMapping("api/products")
    public ResponseEntity<Products> postProduct(@RequestBody Products pe)
    {
        Products obj = ps.create(pe);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    @GetMapping("api/products")
    public ResponseEntity<List<Products>> getAllProductsController()
    {
        List<Products> obj = ps.getAllProducts();
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @GetMapping("api/products/{id}")
    public ResponseEntity<Products> getProductByIdController(@PathVariable int id)
    {
        Products obj = ps.getProductById(id);
        if(obj!=null)
            return new ResponseEntity<>(obj,HttpStatus.OK);
        else
            return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
    }

    @PutMapping("api/products/{id}")
    public ResponseEntity<Products> updateProductsController(@PathVariable int id, @RequestBody Products pe)
    {
        if(ps.updateProducts(id, pe)==true)
            return new ResponseEntity<>(pe, HttpStatus.OK);
        else
            return new ResponseEntity<>(pe,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("api/products/{id}")
    public ResponseEntity<Boolean> deleteProductsController(@PathVariable int id)
    {
        if(ps.deleteProduct(id)==true)
            return new ResponseEntity<>(true,HttpStatus.OK);
        else
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
