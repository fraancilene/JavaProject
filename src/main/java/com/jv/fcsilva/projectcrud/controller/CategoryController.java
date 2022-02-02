package com.jv.fcsilva.projectcrud.controller;

import com.jv.fcsilva.projectcrud.entity.Category;
import com.jv.fcsilva.projectcrud.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    // acessando os usuários
    @GetMapping
    public ResponseEntity<List<Category>> handle(){
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public Category findById(@PathVariable Long id){
        Category obj = categoryService.findById(id);
        return obj;

    }
}
