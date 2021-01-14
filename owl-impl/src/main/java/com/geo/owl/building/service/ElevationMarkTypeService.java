package com.geo.owl.building.service;

import com.geo.owl.building.dto.justification.ElevationMarkTypeDto;

import java.util.List;

public interface ElevationMarkTypeService {
    List<ElevationMarkTypeDto> findAll();
}
