package com.geo.owl.controllers;

import com.geo.owl.building.api.BuildingObjectApi;
import com.geo.owl.building.dto.BuildingObjectDto;
import com.geo.owl.common.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/building_objects")
public class BuildingObjectController {

    private final BuildingObjectApi api;

    @PostMapping("/create")
    public ApiResult<BuildingObjectDto> createBuildingObject(@RequestBody BuildingObjectDto dto) {
        return api.createBuildingObject(dto);
    }

    @PostMapping("/update")
    public ApiResult<BuildingObjectDto> updateBuildingObject(@RequestParam BuildingObjectDto dto) {
        return api.updateBuildingObject(dto);
    }

    @GetMapping("/get")
    public ApiResult<BuildingObjectDto> updateBuildingObject(@RequestParam String id) {
        return api.findBuildingObject(id);
    }

    @GetMapping("/getAll")
    public ApiResult<List<BuildingObjectDto>> findAllBuildingObjects() {
        return api.findAllBuildingObject();
    }
}
