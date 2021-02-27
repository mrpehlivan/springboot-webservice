package com.arifpehlivan.springbootwebservice.respositories;

import com.arifpehlivan.springbootwebservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByFirstName(final String firstName);
}
