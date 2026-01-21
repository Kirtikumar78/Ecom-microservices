package com.ecommerce.order.dto;

import lombok.Data;

@Data
public class AddressDto {

    private String street;
    private String city;
    private String country;
    private String state;
    private String zipcode;
}
