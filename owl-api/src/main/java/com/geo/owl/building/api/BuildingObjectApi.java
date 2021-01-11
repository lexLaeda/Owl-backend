package com.geo.owl.building.api;

import com.geo.owl.building.dto.BuildingObjectDto;
import com.geo.owl.common.ApiResult;

import java.util.List;

public interface BuildingObjectApi {
    ApiResult<BuildingObjectDto> createBuildingObject(BuildingObjectDto buildingObject);

    ApiResult<BuildingObjectDto> updateBuildingObject(BuildingObjectDto buildingObject);

    ApiResult<BuildingObjectDto> findBuildingObject(String objectId);

    ApiResult<List<BuildingObjectDto>> findAllBuildingObject();
}
