package com.arifpehlivan.springbootwebservice.respositories;

import com.arifpehlivan.springbootwebservice.models.Customer;
import com.arifpehlivan.springbootwebservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomer(final Customer customer);
}
