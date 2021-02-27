package com.arifpehlivan.springbootwebservice.services;

import com.arifpehlivan.springbootwebservice.BaseTest;
import com.arifpehlivan.springbootwebservice.respositories.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest extends BaseTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void shouldFindCustomerByFirstName() {
        //Given
        var customer = createCustomer();

        //When
        Mockito.when(customerRepository.findByFirstName(Mockito.any(String.class))).thenReturn(customer);
        var response = customerService.findCustomerByFirstName(customer.getFirstName());

        //Then
        Assert.assertNotNull(response);
        Assert.assertEquals(customer.getFirstName(), response.getFirstName());
        Assert.assertEquals(customer.getLastName(), response.getLastName());
    }

}
