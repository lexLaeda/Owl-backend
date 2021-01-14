package com.geo.owl.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.geo.owl.building.dto.WorkAreaTypeDto;
import com.geo.owl.building.dto.justification.BasePointTypeDto;
import com.geo.owl.building.dto.justification.ElevationMarkTypeDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DictionaryDto {
    private List<BasePointTypeDto> basePointTypes;
    private List<ElevationMarkTypeDto> elevationMarkTypes;
    private List<WorkAreaTypeDto> workAreaTypes;
}
