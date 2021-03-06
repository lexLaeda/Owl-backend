package com.geo.owl.building.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {
    private String objectId;
    private String city;
    private String street;
    private String house;
}
