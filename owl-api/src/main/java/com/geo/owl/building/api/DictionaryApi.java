package com.geo.owl.building.api;

import com.geo.owl.common.ApiResult;
import com.geo.owl.common.DictionaryDto;

public interface DictionaryApi {
    ApiResult<DictionaryDto> getAllDictionaries();
}
