package com.example.demo.resources;
import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> findAll () {
        List<Product> userList = productService.findAll();
        return ResponseEntity.ok().body(userList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById (@PathVariable Long id) {
        Product order = productService.findById(id);
       return ResponseEntity.ok().body(order);
    }


}
