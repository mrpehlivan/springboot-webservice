package com.arifpehlivan.springbootwebservice.services;

import com.arifpehlivan.springbootwebservice.models.Customer;
import com.arifpehlivan.springbootwebservice.respositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CustomerService to manage customer specific operations.
 */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    public Customer findCustomerByFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new RuntimeException("Customer first name can not be null/empty.");
        }
        return customerRepository.findByFirstName(firstName);
    }
}
