package com.jv.fcsilva.projectcrud.repository;


import com.jv.fcsilva.projectcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
