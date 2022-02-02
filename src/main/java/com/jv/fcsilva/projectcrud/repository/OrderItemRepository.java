package com.jv.fcsilva.projectcrud.repository;


import com.jv.fcsilva.projectcrud.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
