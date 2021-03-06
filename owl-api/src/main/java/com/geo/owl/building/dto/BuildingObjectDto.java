package com.geo.owl.building.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildingObjectDto {
    private String objectId;
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;
    private AddressDto address;
    private List<WorkAreaDto> workAreas = new ArrayList<>();
}
