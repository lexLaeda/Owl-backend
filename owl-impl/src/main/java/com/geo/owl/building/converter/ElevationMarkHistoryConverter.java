package com.geo.owl.building.converter;

import com.geo.owl.building.dto.justification.ElevationMarkHistoryDto;
import com.geo.owl.building.model.ElevationMarkHistory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Objects.isNull;
import static org.springframework.util.CollectionUtils.isEmpty;

@Component
public class ElevationMarkHistoryConverter {

    public ElevationMarkHistory convert(ElevationMarkHistoryDto dto) {
        if (isNull(dto)) {
            return null;
        }
        return new ElevationMarkHistory()
                .setObjectId(dto.getObjectId())
                .setElevationMarkId(dto.getElevationMarkId())
                .setName(dto.getName())
                .setVersion(dto.getVersion())
                .setElevationMarkType(dto.getElevationMarkType())
                .setH(dto.getH())
                .setMeasurementDate(dto.getMeasurementDate());
    }

    public ElevationMarkHistoryDto convert(ElevationMarkHistory history) {
        if (isNull(history)) {
            return null;
        }
        return new ElevationMarkHistoryDto()
                .setObjectId(history.getObjectId())
                .setElevationMarkId(history.getElevationMarkId())
                .setName(history.getName())
                .setElevationMarkType(history.getElevationMarkType())
                .setVersion(history.getVersion())
                .setH(history.getH())
                .setMeasurementDate(history.getMeasurementDate());
    }

    public Set<ElevationMarkHistory> convert(List<ElevationMarkHistoryDto> histories) {
        if (isEmpty(histories)) {
            return emptySet();
        }
        return histories.stream()
                .map(this::convert)
                .collect(Collectors.toSet());
    }

    public List<ElevationMarkHistoryDto> convert(Set<ElevationMarkHistory> histories) {
        if (isEmpty(histories)) {
            return emptyList();
        }
        return histories.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
