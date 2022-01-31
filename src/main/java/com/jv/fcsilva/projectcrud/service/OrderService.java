package com.jv.fcsilva.projectcrud.service;

import com.jv.fcsilva.projectcrud.entity.Order;
import com.jv.fcsilva.projectcrud.repository.OrderRepository;
import com.jv.fcsilva.projectcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    // método que retorna todos os usuários do banco
    public List<Order> findAll(){
        return repository.findAll();
    }

    // metodo que retorna o usuário pelo id
    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
