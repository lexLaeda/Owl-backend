package com.geo.owl.building.converter;

import com.geo.owl.building.dto.WorkAreaTypeDto;
import com.geo.owl.building.model.WorkAreaType;
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
public class WorkAreaTypeConverter extends BaseDictionaryConverter {

    public WorkAreaType convert(WorkAreaTypeDto dto) {
        if (isNull(dto)) {
            return null;
        }
        val area = new WorkAreaType();
        update(area, dto);
        return area;
    }

    public WorkAreaTypeDto convert(WorkAreaType workAreaType) {
        if (isNull(workAreaType)) {
            return null;
        }
        val dto = new WorkAreaTypeDto();
        updateDto(workAreaType, dto);
        return dto;
    }

    public Set<WorkAreaType> convert(List<WorkAreaTypeDto> workAreaTypes) {
        if (isEmpty(workAreaTypes)) {
            return emptySet();
        }
        return workAreaTypes.stream()
                .map(this::convert)
                .collect(Collectors.toSet());
    }

    public List<WorkAreaTypeDto> convert(Set<WorkAreaType> workAreaTypes) {
        if (isEmpty(workAreaTypes)) {
            return emptyList();
        }
        return workAreaTypes.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
