package com.arifpehlivan.springbootwebservice.models;

import com.arifpehlivan.springbootwebservice.enums.AddressType;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    @Column(name = "address_name")
    private String addressName;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "address_type")
    @Enumerated(value = EnumType.STRING)
    private AddressType addressType;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
