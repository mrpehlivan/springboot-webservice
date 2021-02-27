package com.arifpehlivan.springbootwebservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO implements Serializable {
    @JsonProperty("first_name")
    private String firstName;
}
