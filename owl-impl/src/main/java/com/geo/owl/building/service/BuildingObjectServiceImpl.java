package com.geo.owl.building.service;

import com.geo.owl.building.dto.BuildingObjectDto;
import com.geo.owl.building.model.Address;
import com.geo.owl.building.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

import static java.util.Arrays.asList;

@Slf4j
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

    @Override
    public BuildingObjectDto updateBuildingObject(BuildingObjectDto buildingObject) {
        return null;
    }

    @Override
    public BuildingObjectDto findBuildingObject(String objectId) {
        return null;
    }
}
