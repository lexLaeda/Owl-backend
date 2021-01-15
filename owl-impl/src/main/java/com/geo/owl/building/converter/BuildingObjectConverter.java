package com.geo.owl.building.converter;

import com.geo.owl.building.dto.BuildingObjectDto;
import com.geo.owl.building.model.BuildingObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Objects.isNull;
import static org.springframework.util.CollectionUtils.isEmpty;

@Component
@RequiredArgsConstructor
public class BuildingObjectConverter {

    private final AddressConverter addressConverter;
    private final WorkAreaConverter workAreaConverter;

    public BuildingObject convert(BuildingObjectDto dto) {
        if (isNull(dto)) {
            return null;
        }
        return new BuildingObject()
                .setObjectId(dto.getObjectId())
                .setName(dto.getName())
                .setStartDate(dto.getStartDate())
                .setEndDate(dto.getEndDate())
               .setAddress(addressConverter.convert(dto.getAddress()))
                .setWorkAreas(workAreaConverter.convert(dto.getWorkAreas()));
    }

    public BuildingObjectDto convert(BuildingObject buildingObject) {
        if (isNull(buildingObject)) {
            return null;
        }
        return new BuildingObjectDto()
                .setObjectId(buildingObject.getObjectId())
                .setName(buildingObject.getName())
                .setStartDate(buildingObject.getStartDate())
                .setEndDate(buildingObject.getEndDate())
                .setAddress(addressConverter.convert(buildingObject.getAddress()))
                .setWorkAreas(workAreaConverter.convert(buildingObject.getWorkAreas()));
    }

    public Set<BuildingObject> convert(List<BuildingObjectDto> buildingObjects) {
        if (isEmpty(buildingObjects)) {
            return emptySet();
        }
        return buildingObjects.stream()
                .map(this::convert)
                .collect(Collectors.toSet());
    }

    public List<BuildingObjectDto> convert(Collection<BuildingObject> buildingObjects) {
        if (isEmpty(buildingObjects)) {
            return emptyList();
        }
        return buildingObjects.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
