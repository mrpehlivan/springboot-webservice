package com.arifpehlivan.springbootwebservice.services;

import com.arifpehlivan.springbootwebservice.BaseTest;
import com.arifpehlivan.springbootwebservice.models.Customer;
import com.arifpehlivan.springbootwebservice.respositories.AddressRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest extends BaseTest {

    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @Test
    public void shouldFindCustomerByFirstName() {
        //Given
        var customer = createCustomer();
        var address = createAddress(customer);

        //When
        Mockito.when(addressRepository.findByCustomer(Mockito.any(Customer.class))).thenReturn(List.of(address));
        var response = addressService.findAddressesByCustomer(customer);

        //Then
        Assert.assertEquals(1, response.size());
        var addressItem = response.stream().findFirst().get();
        Assert.assertNotNull(addressItem);
        Assert.assertEquals(address.getAddressName(), addressItem.getAddressName());
        Assert.assertEquals(address.getZipCode(), addressItem.getZipCode());
        Assert.assertEquals(address.getHouseNumber(), addressItem.getHouseNumber());
        Assert.assertEquals(address.getCountryCode(), addressItem.getCountryCode());
        Assert.assertEquals(address.getCity(), addressItem.getCity());
    }
}
