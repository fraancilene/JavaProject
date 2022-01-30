package com.jv.fcsilva.projectcrud.repository;


import com.jv.fcsilva.projectcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
