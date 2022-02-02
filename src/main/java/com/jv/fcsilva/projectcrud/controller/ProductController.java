package com.jv.fcsilva.projectcrud.controller;

import com.jv.fcsilva.projectcrud.entity.Product;
import com.jv.fcsilva.projectcrud.entity.User;
import com.jv.fcsilva.projectcrud.service.ProductService;
import com.jv.fcsilva.projectcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    // acessando os usuários
    @GetMapping
    public ResponseEntity<List<Product>> handle(){
        List<Product> list = productService.findAll();
        System.out.println(list);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable Long id){
        Product obj = productService.findById(id);
        return obj;

    }


}
