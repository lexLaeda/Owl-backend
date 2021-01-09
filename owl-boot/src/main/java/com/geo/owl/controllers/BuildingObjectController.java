package com.geo.owl.controllers;

import com.geo.owl.building.dto.BuildingObjectDto;
import com.geo.owl.building.service.BuildingObjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/building_objects")
public class BuildingObjectController {

    private final BuildingObjectService objectService;

    @PostMapping("/create")
    public BuildingObjectDto createBuildingObject(@RequestBody BuildingObjectDto buildingObject) {
        return objectService.createBuildingObject(buildingObject);
    }

    @GetMapping("/get")
    public List<BuildingObjectDto> findAllBuildingObjects() {
        return objectService.findAllBuildingObjects();
    }
}
