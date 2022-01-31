package com.jv.fcsilva.projectcrud.controller;

import com.jv.fcsilva.projectcrud.entity.Order;
import com.jv.fcsilva.projectcrud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "/orders")
public class OrderController {

        @Autowired
        private OrderService orderService;


        // acessando os usuários
        @GetMapping
        public ResponseEntity<List<Order>> handle(){
            List<Order> list = orderService.findAll();
            return ResponseEntity.ok().body(list);
        }

        @GetMapping(value = "/{id}")
        public Order findById(@PathVariable Long id){
            Order obj = orderService.findById(id);
            return obj;

        }
}
