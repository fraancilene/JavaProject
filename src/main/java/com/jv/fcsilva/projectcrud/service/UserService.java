package com.jv.fcsilva.projectcrud.service;

import com.jv.fcsilva.projectcrud.entity.User;
import com.jv.fcsilva.projectcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // método que retorna todos os usuários do banco
    public List<User> findAll(){
        return repository.findAll();
    }

    // metodo que retorna o usuário pelo id
    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

}
