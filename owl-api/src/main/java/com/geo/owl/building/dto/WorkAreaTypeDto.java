package com.geo.owl.building.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.geo.owl.common.BaseDictionaryDto;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkAreaTypeDto extends BaseDictionaryDto {
}
