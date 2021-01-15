package com.geo.owl.building.api;

import com.geo.owl.building.service.DictionaryComposeService;
import com.geo.owl.common.ApiProxy;
import com.geo.owl.common.ApiResult;
import com.geo.owl.common.DictionaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DictionaryApiImpl implements DictionaryApi {

    private final ApiProxy proxy;
    private final DictionaryComposeService service;

    @Override
    public ApiResult<DictionaryDto> getAllDictionaries() {
        return proxy.proceed(service::getAllDictionaries);
    }
}
