package com.geo.owl.building.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AddressDto {
    private String objectId;
    private String city;
    private String street;
    private String house;
}
