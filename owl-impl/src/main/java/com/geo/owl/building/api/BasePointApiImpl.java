package com.geo.owl.building.api;

import com.geo.owl.building.dto.justification.BasePointDto;
import com.geo.owl.building.service.BasePointService;
import com.geo.owl.common.ApiProxy;
import com.geo.owl.common.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BasePointApiImpl implements BasePointApi {

    private final ApiProxy proxy;
    private final BasePointService service;

    @Override
    public ApiResult<BasePointDto> updateBasePoint(BasePointDto dto) {
        return proxy.proceed(() -> service.updateBasePoint(dto));
    }
}
