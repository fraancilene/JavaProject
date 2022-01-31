package com.jv.fcsilva.projectcrud.repository;


import com.jv.fcsilva.projectcrud.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
