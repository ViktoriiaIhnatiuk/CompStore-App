package com.example.compstore.repository;

import com.example.compstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT* "
            + "FROM orders o "
            + "LEFT JOIN users u "
            + "ON o.user_id = u.id "
            + "WHERE u.email = ?;", nativeQuery = true)
    List<Order> getAllOrdersByUserEmail(String userEmail);
}
