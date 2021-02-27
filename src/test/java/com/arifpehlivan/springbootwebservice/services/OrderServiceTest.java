package com.arifpehlivan.springbootwebservice.services;

import com.arifpehlivan.springbootwebservice.BaseTest;
import com.arifpehlivan.springbootwebservice.models.Customer;
import com.arifpehlivan.springbootwebservice.models.Order;
import com.arifpehlivan.springbootwebservice.respositories.OrderRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest extends BaseTest {


    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void shouldListOrderByCustomer() {
        //Given
        var customer = createCustomer();
        var order = createOrder(customer);

        //When
        Mockito.when(orderRepository.findByCustomer(Mockito.any(Customer.class))).thenReturn(List.of(order));
        var response = orderService.findOrderByCustomer(customer);

        //Then
        Assert.assertEquals(1, response.size());
        Order responseItem = response.stream().findFirst().get();
        Assert.assertNotNull(responseItem);
        Assert.assertEquals(order.getOrderName(), responseItem.getOrderName());
        Assert.assertEquals(order.getOrderCategory(), responseItem.getOrderCategory());
    }
}
