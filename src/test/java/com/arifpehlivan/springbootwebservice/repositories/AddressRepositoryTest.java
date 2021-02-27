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
public class AddressRepositoryTest extends BaseTest {

    @Test
    public void shouldCreateAddress() {
        //Given
        Customer customer = createCustomer();
        var address = createAddress(customer);

        //When
        var response = addressRepository.save(address);

        //Then
        Assert.assertNotNull(response);
        Assert.assertEquals(address.getAddressName(), response.getAddressName());
        Assert.assertEquals(address.getAddressType(), response.getAddressType());
        Assert.assertEquals(address.getCity(), response.getCity());
        Assert.assertEquals(address.getCountryCode(), response.getCountryCode());
        Assert.assertEquals(address.getHouseNumber(), response.getHouseNumber());
        Assert.assertEquals(address.getZipCode(), response.getZipCode());
        Assert.assertEquals(address.getCustomer().getLastName(), response.getCustomer().getLastName());
        Assert.assertEquals(address.getCustomer().getFirstName(), response.getCustomer().getFirstName());
    }
}
