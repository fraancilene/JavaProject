package com.jv.fcsilva.projectcrud.repository;

import com.jv.fcsilva.projectcrud.entity.Category;
import com.jv.fcsilva.projectcrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
