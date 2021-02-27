package com.arifpehlivan.springbootwebservice.controllers;

import com.arifpehlivan.springbootwebservice.dtos.CustomerRequestDTO;
import com.arifpehlivan.springbootwebservice.dtos.CustomerResponseDTO;
import com.arifpehlivan.springbootwebservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponseDTO findCustomerByFirstName(@RequestBody CustomerRequestDTO requestDTO) {
        var customer = customerService.findCustomerByFirstName(requestDTO.getFirstName());
        return CustomerResponseDTO.builder().firstName(customer.getFirstName()).lastName(customer.getLastName()).build();
    }
}
