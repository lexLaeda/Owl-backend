package com.geo.owl.building.dto.justification;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.geo.owl.common.BaseDictionaryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElevationMarkTypeDto extends BaseDictionaryDto {
}
