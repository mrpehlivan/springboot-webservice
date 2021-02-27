package com.arifpehlivan.springbootwebservice.respositories;

import com.arifpehlivan.springbootwebservice.models.Address;
import com.arifpehlivan.springbootwebservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByCustomer(final Customer customer);
}
