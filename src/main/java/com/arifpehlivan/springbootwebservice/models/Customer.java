package com.arifpehlivan.springbootwebservice.models;


import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Data
@SuperBuilder
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Address> addresses;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders;

}
