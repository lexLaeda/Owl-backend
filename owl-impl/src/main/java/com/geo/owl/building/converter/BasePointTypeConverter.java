package com.geo.owl.building.converter;

import com.geo.owl.building.dto.justification.BasePointTypeDto;
import com.geo.owl.building.model.BasePointType;
import com.geo.owl.common.converter.BaseDictionaryConverter;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Objects.isNull;
import static org.springframework.util.CollectionUtils.isEmpty;

@Component
public class BasePointTypeConverter extends BaseDictionaryConverter {

    public BasePointType convert(BasePointTypeDto dto) {
        if (isNull(dto)) {
            return null;
        }
        val pointType = new BasePointType();
        update(pointType, dto);
        return pointType;
    }

    public BasePointTypeDto convert(BasePointType pointType) {
        if (isNull(pointType)) {
            return null;
        }
        val dto = new BasePointTypeDto();
        updateDto(pointType, dto);
        return dto;
    }

    public Set<BasePointType> convert(List<BasePointTypeDto> pointTypes) {
        if (isEmpty(pointTypes)) {
            return emptySet();
        }
        return pointTypes.stream()
                .map(this::convert)
                .collect(Collectors.toSet());
    }

    public List<BasePointTypeDto> convert(Set<BasePointType> pointTypes) {
        if (isEmpty(pointTypes)) {
            return emptyList();
        }
        return pointTypes.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
