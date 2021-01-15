package com.geo.owl.building.converter;

import com.geo.owl.building.dto.justification.BasePointHistoryDto;
import com.geo.owl.building.model.BasePointHistory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Objects.isNull;
import static org.springframework.util.CollectionUtils.isEmpty;

@Component
public class BasePointHistoryConverter {

    public BasePointHistory convert(BasePointHistoryDto dto) {
        if (isNull(dto)) {
            return null;
        }
        return new BasePointHistory()
                .setObjectId(dto.getObjectId())
                .setBasePointType(dto.getPointType())
                .setName(dto.getName())
                .setMeasurementDate(dto.getMeasurementDate())
                .setBasePointId(dto.getBasePointId())
                .setX(dto.getX())
                .setY(dto.getY())
                .setH(dto.getH())
                .setVersion(dto.getVersion());
    }

    public BasePointHistoryDto convert(BasePointHistory history) {
        if (isNull(history)) {
            return null;
        }
        return new BasePointHistoryDto()
                .setObjectId(history.getObjectId())
                .setPointType(history.getBasePointType())
                .setName(history.getName())
                .setMeasurementDate(history.getMeasurementDate())
                .setBasePointId(history.getBasePointId())
                .setX(history.getX())
                .setY(history.getY())
                .setH(history.getH())
                .setVersion(history.getVersion());
    }

    public Set<BasePointHistory> convert(List<BasePointHistoryDto> histories) {
        if (isEmpty(histories)) {
            return emptySet();
        }
        return histories.stream()
                .map(this::convert)
                .collect(Collectors.toSet());
    }

    public List<BasePointHistoryDto> convert(Set<BasePointHistory> histories) {
        if (isEmpty(histories)) {
            return emptyList();
        }
        return histories.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
