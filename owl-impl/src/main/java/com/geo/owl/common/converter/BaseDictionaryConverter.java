package com.geo.owl.common.converter;

import com.geo.owl.common.BaseDictionaryDto;
import com.geo.owl.common.model.BaseDictionary;

public abstract class BaseDictionaryConverter {

    protected void update(BaseDictionary dictionary, BaseDictionaryDto dto) {
        dictionary.setCode(dto.getCode())
                .setNameRu(dto.getNameRu())
                .setNameEn(dto.getNameEn());
    }

    protected void updateDto(BaseDictionary dictionary, BaseDictionaryDto dto) {
        dto.setCode(dictionary.getCode())
                .setNameEn(dictionary.getNameEn())
                .setNameRu(dictionary.getNameRu());

    }
}
