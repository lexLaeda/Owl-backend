package com.geo.owl.building.converter;

import com.geo.owl.building.dto.justification.BasePointDto;
import com.geo.owl.building.model.BasePoint;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Objects.isNull;
import static org.springframework.util.CollectionUtils.isEmpty;

@Component
public class BasePointConverter {


    public BasePoint convert(BasePointDto dto) {
        if (isNull(dto)) {
            return null;
        }
        return new BasePoint()
                .setObjectId(dto.getObjectId())
                .setName(dto.getName())
                .setX(dto.getX())
                .setY(dto.getY())
                .setH(dto.getH())
                .setCreated(dto.getCreated())
                .setLastUpdated(dto.getLastUpdated())
                .setPointType(dto.getPointType())
                .setVersion(dto.getVersion());
    }

    public BasePointDto convert(BasePoint basePoint) {
        if (isNull(basePoint)) {
            return null;
        }
        return new BasePointDto()
                .setObjectId(basePoint.getObjectId())
                .setName(basePoint.getName())
                .setX(basePoint.getX())
                .setY(basePoint.getY())
                .setH(basePoint.getH())
                .setCreated(basePoint.getCreated())
                .setLastUpdated(basePoint.getLastUpdated())
                .setPointType(basePoint.getPointType())
                .setVersion(basePoint.getVersion());
    }

    public Set<BasePoint> convert(List<BasePointDto> points) {
        if (isEmpty(points)) {
            return emptySet();
        }
        return points.stream()
                .map(this::convert)
                .collect(Collectors.toSet());
    }

    public List<BasePointDto> convert(Set<BasePoint> basePoints) {
        if (isEmpty(basePoints)) {
            return emptyList();
        }
        return basePoints.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
