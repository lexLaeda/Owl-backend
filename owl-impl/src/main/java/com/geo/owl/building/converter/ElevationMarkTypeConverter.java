package com.geo.owl.building.converter;

import com.geo.owl.building.dto.justification.ElevationMarkTypeDto;
import com.geo.owl.building.model.ElevationMarkType;
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
public class ElevationMarkTypeConverter extends BaseDictionaryConverter {

    public ElevationMarkType convert(ElevationMarkTypeDto dto) {
        if (isNull(dto)) {
            return null;
        }
        val elevationMarkType = new ElevationMarkType();
        update(elevationMarkType, dto);
        return elevationMarkType;
    }

    public ElevationMarkTypeDto convert(ElevationMarkType elevationMartType) {
        if (isNull(elevationMartType)) {
            return null;
        }
        val dto = new ElevationMarkTypeDto();
        updateDto(elevationMartType, dto);
        return dto;
    }

    public Set<ElevationMarkType> convert(List<ElevationMarkTypeDto> elevationMarkTypes) {
        if (isEmpty(elevationMarkTypes)) {
            return emptySet();
        }
        return elevationMarkTypes.stream()
                .map(this::convert)
                .collect(Collectors.toSet());
    }

    public List<ElevationMarkTypeDto> convert(Set<ElevationMarkType> elevationMarkTypes) {
        if (isEmpty(elevationMarkTypes)) {
            return emptyList();
        }
        return elevationMarkTypes.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
