package com.jv.fcsilva.projectcrud.repository;

import com.jv.fcsilva.projectcrud.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
