package com.jv.fcsilva.projectcrud.service;

import com.jv.fcsilva.projectcrud.entity.Category;
import com.jv.fcsilva.projectcrud.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    // método que retorna todos os usuários do banco
    public List<Category> findAll(){
        return repository.findAll();
    }

    // metodo que retorna o usuário pelo id
    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
