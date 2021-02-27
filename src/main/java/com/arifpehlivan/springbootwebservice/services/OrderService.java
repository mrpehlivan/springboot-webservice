package com.arifpehlivan.springbootwebservice.services;

import com.arifpehlivan.springbootwebservice.models.Customer;
import com.arifpehlivan.springbootwebservice.models.Order;
import com.arifpehlivan.springbootwebservice.respositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OrderService to manage order specific operations.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findOrderByCustomer(final Customer customer) {
        return orderRepository.findByCustomer(customer);
    }
}
