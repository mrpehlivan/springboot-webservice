package com.arifpehlivan.springbootwebservice.services;

import com.arifpehlivan.springbootwebservice.BaseTest;
import com.arifpehlivan.springbootwebservice.models.Order;
import com.arifpehlivan.springbootwebservice.models.OrderItem;
import com.arifpehlivan.springbootwebservice.respositories.OrderItemRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemServiceTest extends BaseTest {

    @InjectMocks
    private OrderItemService orderItemService;

    @Mock
    private OrderItemRepository orderItemRepository;

    @Test
    public void shouldListOrderItemsByOrder() {
        //Given
        var customer = createCustomer();
        var order = createOrder(customer);
        var orderItem = createOrderItem(order);

        //When
        Mockito.when(orderItemRepository.findByOrder(Mockito.any(Order.class))).thenReturn(List.of(orderItem));
        var response = orderItemService.findOrderItemsByOrder(order);

        //Then
        Assert.assertEquals(1, response.size());
        OrderItem item = response.stream().findFirst().get();
        Assert.assertNotNull(item);
        Assert.assertEquals(orderItem.getItemAmount(), item.getItemAmount());
        Assert.assertEquals(orderItem.getItemName(), item.getItemName());
    }

}
