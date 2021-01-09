package com.geo.owl.building.api;

import com.geo.owl.building.dto.BuildingObjectDto;
import com.geo.owl.building.service.BuildingObjectService;
import com.geo.owl.common.ApiProxy;
import com.geo.owl.common.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class BuildingObjectApiImpl implements BuildingObjectApi {

    private final BuildingObjectService service;
    private final ApiProxy proxy;

    @Override
    public ApiResult<BuildingObjectDto> createBuildingObject(BuildingObjectDto buildingObject) {
        return proxy.proceed(() -> service.createBuildingObject(buildingObject));
    }

    @Override
    public ApiResult<BuildingObjectDto> updateBuildingObject(BuildingObjectDto buildingObject) {
        return proxy.proceed(() -> service.updateBuildingObject(buildingObject));
    }

    @Override
    public ApiResult<BuildingObjectDto> findBuildingObject(String objectId) {
        return proxy.proceed(() -> service.findBuildingObject(objectId));
    }

    @Override
    public ApiResult<List<BuildingObjectDto>> findAllBuildingObject(
            BuildingObjectDto buildingObject
    ) {
        return proxy.proceed(service::findAllBuildingObjects);
    }

}
