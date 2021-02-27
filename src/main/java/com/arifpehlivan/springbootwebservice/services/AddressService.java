package com.arifpehlivan.springbootwebservice.services;

import com.arifpehlivan.springbootwebservice.models.Address;
import com.arifpehlivan.springbootwebservice.models.Customer;
import com.arifpehlivan.springbootwebservice.respositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AddressService to manage address specific operations.
 */
@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(final AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    List<Address> findAddressesByCustomer(final Customer customer) {
        return addressRepository.findByCustomer(customer);
    }
}
