package com.ecommerce.user.Models;


import lombok.Data;


@Data


public class Address {

    private Long id;
    private String street;
    private String city;
    private String country;
    private String state;
    private String zipcode;


}
