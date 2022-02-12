package com.jv.fcsilva.projectcrud.controller;

import com.jv.fcsilva.projectcrud.entity.User;
import com.jv.fcsilva.projectcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;


    // acessando os usuários
    @GetMapping
    public ResponseEntity<List<User>> handle(){
        List<User> list = userService.findAll();
        System.out.println(list);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
        User obj = userService.findById(id);
        return obj;

//        return new Test("tes");

    }


}
