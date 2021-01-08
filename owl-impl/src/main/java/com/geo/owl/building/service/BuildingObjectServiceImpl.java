package com.geo.owl.building.service;

import com.geo.owl.building.dto.BuildingObjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class BuildingObjectServiceImpl implements BuildingObjectService {
    @Override
    public BuildingObjectDto createBuildingObject(BuildingObjectDto buildingObject) {
        return null;
    }

    @Override
    public List<BuildingObjectDto> findAllBuildingObjects() {
        return asList(new BuildingObjectDto(), new BuildingObjectDto());
    }
}
