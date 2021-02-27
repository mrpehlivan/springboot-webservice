package com.arifpehlivan.springbootwebservice.models;

import com.arifpehlivan.springbootwebservice.enums.OrderCategory;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Data
@SuperBuilder
@Entity
@Table(name = "order_table")
public class Order extends BaseEntity {

    @Column(name = "order_name", nullable = false)
    private String orderName;

    @Column(name = "order_category", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private OrderCategory orderCategory;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
