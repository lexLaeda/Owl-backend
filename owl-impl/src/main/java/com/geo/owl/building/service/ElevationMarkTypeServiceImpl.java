package com.geo.owl.building.service;

import com.geo.owl.building.converter.ElevationMarkTypeConverter;
import com.geo.owl.building.dto.justification.ElevationMarkTypeDto;
import com.geo.owl.building.repository.ElevationMarkTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElevationMarkTypeServiceImpl implements ElevationMarkTypeService {

    private final ElevationMarkTypeConverter converter;
    private final ElevationMarkTypeRepository repository;

    @Override
    public List<ElevationMarkTypeDto> findAll() {
        val elevationMarkTypes = repository.findAll();
        return elevationMarkTypes.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
