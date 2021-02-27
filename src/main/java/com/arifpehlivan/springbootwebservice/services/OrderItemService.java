package com.arifpehlivan.springbootwebservice.services;

import com.arifpehlivan.springbootwebservice.models.Order;
import com.arifpehlivan.springbootwebservice.models.OrderItem;
import com.arifpehlivan.springbootwebservice.respositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OrderItemService to manage order item specific operations.
 */
@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(final OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }


    public List<OrderItem> findOrderItemsByOrder(final Order order) {
        return orderItemRepository.findByOrder(order);
    }
}
