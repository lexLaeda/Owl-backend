package com.geo.owl.building.api;

import com.geo.owl.building.dto.justification.BasePointDto;
import com.geo.owl.common.ApiResult;

public interface BasePointApi {
    ApiResult<BasePointDto> updateBasePoint(BasePointDto dto);
}
