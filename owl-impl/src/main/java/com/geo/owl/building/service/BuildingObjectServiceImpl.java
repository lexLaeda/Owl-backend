package com.geo.owl.building.service;

import com.geo.owl.building.converter.BuildingObjectConverter;
import com.geo.owl.building.dto.BuildingObjectDto;
import com.geo.owl.building.repository.BuildingObjectRepository;
import com.geo.owl.building.validation.BuildingObjectValidator;
import com.geo.owl.common.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuildingObjectServiceImpl implements BuildingObjectService {

    private final BuildingObjectValidator validator;
    private final BuildingObjectRepository repository;
    private final BuildingObjectConverter converter;

    @Override
    public BuildingObjectDto createBuildingObject(BuildingObjectDto buildingObject) {
        validateCreation(buildingObject);
        validator.validate(buildingObject);
        val converted = converter.convert(buildingObject);
        val saved = repository.saveAndFlush(converted);
        return converter.convert(saved);
    }

    @Override
    public List<BuildingObjectDto> findAllBuildingObjects() {
        val all = repository.findAll();
        return converter.convert(all);
    }

    @Override
    public BuildingObjectDto updateBuildingObject(BuildingObjectDto buildingObject) {
        validateUpdate(buildingObject);
        val converted = converter.convert(buildingObject);
        val saved = repository.saveAndFlush(converted);
        return converter.convert(saved);
    }

    private void validateUpdate(BuildingObjectDto buildingObject) {
        val id = buildingObject.getObjectId();
        if (isNull(id)) {
            throw new ValidationException("Miss building object id");
        }
        val fromDb = repository.findById(id);
        if (fromDb.isPresent()) {
            return;
        }
        throw new ValidationException(getNotFoundMsg(id));
    }

    @Override
    public BuildingObjectDto findBuildingObject(String id) {
        return repository.findById(id)
                .map(converter::convert)
                .orElseThrow(() -> new ValidationException(getNotFoundMsg(id)));
    }

    private void validateCreation(BuildingObjectDto buildingObject) {
        if (nonNull(buildingObject.getObjectId())) {
            throw new ValidationException("Building object already have id");
        }
    }

    private String getNotFoundMsg(String id) {
        return String.format("Building object with id %s is not present", id);
    }
}
