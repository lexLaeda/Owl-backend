package com.geo.owl.building.service;

import com.geo.owl.building.dto.BuildingObjectDto;

import java.util.List;

public interface BuildingObjectService {
    BuildingObjectDto createBuildingObject(BuildingObjectDto buildingObject);

    List<BuildingObjectDto> findAllBuildingObjects();

    BuildingObjectDto updateBuildingObject(BuildingObjectDto buildingObject);

    BuildingObjectDto findBuildingObject(String objectId);
}
