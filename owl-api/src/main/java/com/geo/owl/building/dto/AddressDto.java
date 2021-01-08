package com.geo.owl.building.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String objectId;
    private String country;
    private String city;
    private String street;
    private String house;
}
