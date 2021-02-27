package com.arifpehlivan.springbootwebservice;

import com.arifpehlivan.springbootwebservice.enums.AddressType;
import com.arifpehlivan.springbootwebservice.enums.OrderCategory;
import com.arifpehlivan.springbootwebservice.models.Address;
import com.arifpehlivan.springbootwebservice.models.Customer;
import com.arifpehlivan.springbootwebservice.models.Order;
import com.arifpehlivan.springbootwebservice.models.OrderItem;
import com.arifpehlivan.springbootwebservice.respositories.AddressRepository;
import com.arifpehlivan.springbootwebservice.respositories.CustomerRepository;
import com.arifpehlivan.springbootwebservice.respositories.OrderItemRepository;
import com.arifpehlivan.springbootwebservice.respositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.Instant;

public class BaseTest {

    @Autowired
    protected AddressRepository addressRepository;

    @Autowired
    protected CustomerRepository customerRepository;

    @Autowired
    protected OrderRepository orderRepository;

    @Autowired
    protected OrderItemRepository orderItemRepository;

    protected Customer createCustomer() {
        return Customer
                .builder()
                .createdAt(Instant.now())
                .firstName("Arif")
                .lastName("Pehlivan")
                .build();
    }

    protected Address createAddress(final Customer customer) {
        return Address
                .builder()
                .createdAt(Instant.now())
                .addressName("Arif Home Address")
                .houseNumber("5")
                .zipCode("22305")
                .addressType(AddressType.HOME)
                .city("Hamburg")
                .countryCode("DE")
                .customer(customer)
                .build();
    }

    protected Order createOrder(final Customer customer) {
        return Order
                .builder()
                .createdAt(Instant.now())
                .orderName("Computer Arif")
                .orderCategory(OrderCategory.TECHNOLOGY)
                .customer(customer)
                .build();
    }

    protected OrderItem createOrderItem(final Order order) {
        return OrderItem
                .builder()
                .createdAt(Instant.now())
                .itemName("Mac Book Pro 2021")
                .itemAmount(new BigDecimal("1200"))
                .order(order)
                .build();
    }

}
