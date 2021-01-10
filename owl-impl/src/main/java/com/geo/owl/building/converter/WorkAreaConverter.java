package com.geo.owl.building.converter;

import com.geo.owl.building.dto.WorkAreaDto;
import com.geo.owl.building.model.WorkArea;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Objects.isNull;
import static org.springframework.util.CollectionUtils.isEmpty;

@Component
@RequiredArgsConstructor
public class WorkAreaConverter {

    private final BasePointConverter basePointConverter;
    private final ElevationMarkConverter elevationMarkConverter;

    public WorkArea convert(WorkAreaDto dto) {
        if (isNull(dto)) {
            return null;
        }
        return new WorkArea()
                .setObjectId(dto.getObjectId())
                .setName(dto.getName())
                .setWorkAreaType(dto.getWorkAreaType())
                .setStartDate(dto.getStartDate())
                .setEndDate(dto.getEndDate())
                .setBasePoints(basePointConverter.convert(dto.getBasePoints()))
                .setElevationMarks(elevationMarkConverter.convert(dto.getElevationMarks()));
    }

    public WorkAreaDto convert(WorkArea workArea) {
        if (isNull(workArea)) {
            return null;
        }
        return new WorkAreaDto()
                .setObjectId(workArea.getObjectId())
                .setName(workArea.getName())
                .setWorkAreaType(workArea.getWorkAreaType())
                .setStartDate(workArea.getStartDate())
                .setEndDate(workArea.getEndDate())
                .setBasePoints(basePointConverter.convert(workArea.getBasePoints()))
                .setElevationMarks(elevationMarkConverter.convert(workArea.getElevationMarks()));
    }

    public Set<WorkArea> convert(List<WorkAreaDto> workAreas) {
        if (isEmpty(workAreas)) {
            return emptySet();
        }
        return workAreas.stream()
                .map(this::convert)
                .collect(Collectors.toSet());
    }

    public List<WorkAreaDto> convert(Set<WorkArea> workAreas) {
        if (isEmpty(workAreas)) {
            return emptyList();
        }
        return workAreas.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
