package com.jv.fcsilva.projectcrud.service;

import com.jv.fcsilva.projectcrud.entity.Product;
import com.jv.fcsilva.projectcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // método que retorna todos os usuários do banco
    public List<Product> findAll(){
        return repository.findAll();
    }

    // metodo que retorna o usuário pelo id
    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

}
