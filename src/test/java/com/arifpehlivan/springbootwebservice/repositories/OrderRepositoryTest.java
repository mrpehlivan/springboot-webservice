package com.arifpehlivan.springbootwebservice.repositories;

import com.arifpehlivan.springbootwebservice.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest extends BaseTest {

    @Test
    public void shouldCreateOrder() {
        //Given
        var customer = customerRepository.save(createCustomer());
        createAddress(customer);
        var order = createOrder(customer);

        //When
        var response = orderRepository.save(order);

        //Then
        Assert.assertNotNull(response);
        Assert.assertEquals(order.getOrderName(), response.getOrderName());
        Assert.assertEquals(order.getOrderCategory(), response.getOrderCategory());
    }
}
