package com.arifpehlivan.springbootwebservice;

import com.arifpehlivan.springbootwebservice.controllers.CustomerController;
import com.arifpehlivan.springbootwebservice.services.AddressService;
import com.arifpehlivan.springbootwebservice.services.CustomerService;
import com.arifpehlivan.springbootwebservice.services.OrderItemService;
import com.arifpehlivan.springbootwebservice.services.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringbootWebserviceApplicationTests {

    @Autowired
    private CustomerController controller;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
        assertThat(customerService).isNotNull();
        assertThat(addressService).isNotNull();
        assertThat(orderService).isNotNull();
        assertThat(orderItemService).isNotNull();
    }

}
