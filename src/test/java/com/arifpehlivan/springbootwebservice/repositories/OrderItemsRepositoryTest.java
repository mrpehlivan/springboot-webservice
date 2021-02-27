package com.arifpehlivan.springbootwebservice.repositories;

import com.arifpehlivan.springbootwebservice.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderItemsRepositoryTest extends BaseTest {

    @Test
    public void shouldCreateOrderItems() {
        //Given
        var customer = customerRepository.save(createCustomer());
        createAddress(customer);
        var order = orderRepository.save(createOrder(customer));

        //When
        var orderItem = createOrderItem(order);
        var response = orderItemRepository.save(orderItem);

        //Then
        Assert.assertNotNull(response);
        Assert.assertEquals(orderItem.getItemName(), response.getItemName());
        Assert.assertEquals(orderItem.getItemAmount(), response.getItemAmount());
    }
}
