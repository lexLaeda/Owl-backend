package com.geo.owl.building.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BuildingObjectDto {
    private String objectId;
    private String name;
    private AddressDto address;
    private List<WorkSiteDto> workSites = new ArrayList<>();
}
