package com.geo.owl.building.dto.justification;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElevationMarkHistoryDto {
    private String objectId;
    private String name;
    private String elevationMarkType;
    private Double h;
    private Long version;
    private Timestamp measurementDate;
    private String elevationMarkId;

}
