package com.geo.owl.building.service;

import com.geo.owl.building.dto.BuildingObjectDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

import static java.util.Arrays.asList;

@Slf4j
@Service
public class BuildingObjectServiceImpl implements BuildingObjectService {

    @PostConstruct
    public void init() {
        log.info("Ура!!!!!");
    }

    @Override
    public BuildingObjectDto createBuildingObject(BuildingObjectDto buildingObject) {
        return null;
    }

    @Override
    public List<BuildingObjectDto> findAllBuildingObjects() {
        return asList(new BuildingObjectDto(), new BuildingObjectDto());
    }

    @Override
    public BuildingObjectDto updateBuildingObject(BuildingObjectDto buildingObject) {
        return null;
    }

    @Override
    public BuildingObjectDto findBuildingObject(String objectId) {
        return null;
    }
}
