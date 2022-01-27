package com.jv.fcsilva.projectcrud.controller;

import com.jv.fcsilva.projectcrud.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class UserController {


    // acessando os usuários
    @GetMapping(value = "/users")
    public ResponseEntity<User> handle(){
        User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "1234");
        return ResponseEntity.ok().body(u);
    }


}
