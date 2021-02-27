package com.arifpehlivan.springbootwebservice.controllers;

import com.arifpehlivan.springbootwebservice.dtos.CustomerRequestDTO;
import com.arifpehlivan.springbootwebservice.dtos.CustomerResponseDTO;
import com.arifpehlivan.springbootwebservice.models.Customer;
import com.arifpehlivan.springbootwebservice.services.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;
import java.time.Instant;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    final static ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerService customerService;

    public static <T> T parseResponse(MvcResult result, Class<T> responseClass) {
        try {
            String contentAsString = result.getResponse().getContentAsString();
            return objectMapper.readValue(contentAsString, responseClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void findCustomerByFirstName() throws Exception {
        var customer = createCustomer();
        when(customerService.findCustomerByFirstName(anyString())).thenReturn(customer);
        CustomerRequestDTO requestDTO = new CustomerRequestDTO("Arif");

        var response = mockMvc
                .perform(post("/api/v1/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        var customerResponse = parseResponse(response, CustomerResponseDTO.class);
        Assert.assertEquals(customer.getFirstName(), customerResponse.getFirstName());
        Assert.assertEquals(customer.getLastName(), customerResponse.getLastName());
    }

    protected Customer createCustomer() {
        return Customer
                .builder()
                .createdAt(Instant.now())
                .firstName("Arif")
                .lastName("Pehlivan")
                .build();
    }


}
