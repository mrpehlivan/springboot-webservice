package com.arifpehlivan.springbootwebservice.respositories;

import com.arifpehlivan.springbootwebservice.models.Order;
import com.arifpehlivan.springbootwebservice.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.OrderBy;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @OrderBy("created_at DESC")
    List<OrderItem> findByOrder(final Order order);
}
