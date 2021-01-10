package com.geo.owl.building.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.geo.owl.building.dto.justification.BasePointDto;
import com.geo.owl.building.dto.justification.ElevationMarkDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkAreaDto {
    private String objectId;
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;
    private String workAreaType;
    private List<BasePointDto> basePoints = new ArrayList<>();
    private List<ElevationMarkDto> elevationMarks = new ArrayList<>();
}
