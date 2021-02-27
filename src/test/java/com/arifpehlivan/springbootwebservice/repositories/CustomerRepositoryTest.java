package com.arifpehlivan.springbootwebservice.repositories;

import com.arifpehlivan.springbootwebservice.BaseTest;
import com.arifpehlivan.springbootwebservice.models.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest extends BaseTest {

    @Test
    public void shouldCreateCustomer() {
        //Given
        Customer model = createCustomer();

        //When
        var response = customerRepository.save(model);

        //Then
        Assert.assertNotNull(response);
        Assert.assertEquals(model.getFirstName(), response.getFirstName());
        Assert.assertEquals(model.getLastName(), response.getLastName());
    }
}
