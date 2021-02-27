package com.arifpehlivan.springbootwebservice.models;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@SuperBuilder
@Entity
@Table(name = "order_item")
public class OrderItem extends BaseEntity {

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "item_amount", nullable = false)
    private BigDecimal itemAmount;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
