package com.geo.owl.building.converter;

import com.geo.owl.building.dto.justification.ElevationMarkDto;
import com.geo.owl.building.model.ElevationMark;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Objects.isNull;
import static org.springframework.util.CollectionUtils.isEmpty;

@Component
public class ElevationMarkConverter {

    public ElevationMark convert(ElevationMarkDto dto) {
        if (isNull(dto)) {
            return null;
        }
        return new ElevationMark()
                .setObjectId(dto.getObjectId())
                .setName(dto.getName())
                .setVersion(dto.getVersion())
                .setH(dto.getH())
                .setElevationMarkType(dto.getElevationMarkType())
                .setCreated(dto.getCreated())
                .setLastUpdated(dto.getLastUpdated());
    }

    public ElevationMarkDto convert(ElevationMark elevationMark) {
        if (isNull(elevationMark)) {
            return null;
        }
        return new ElevationMarkDto()
                .setObjectId(elevationMark.getObjectId())
                .setName(elevationMark.getName())
                .setVersion(elevationMark.getVersion())
                .setH(elevationMark.getH())
                .setElevationMarkType(elevationMark.getElevationMarkType())
                .setCreated(elevationMark.getCreated())
                .setLastUpdated(elevationMark.getLastUpdated());
    }

    public Set<ElevationMark> convert(List<ElevationMarkDto> elevationMarks) {
        if (isEmpty(elevationMarks)) {
            return emptySet();
        }
        return elevationMarks.stream()
                .map(this::convert)
                .collect(Collectors.toSet());
    }

    public List<ElevationMarkDto> convert(Set<ElevationMark> elevationMarks) {
        if (isEmpty(elevationMarks)) {
            return emptyList();
        }
        return elevationMarks.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
