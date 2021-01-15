package com.geo.owl.building.service;

import com.geo.owl.building.converter.WorkAreaTypeConverter;
import com.geo.owl.building.dto.WorkAreaTypeDto;
import com.geo.owl.building.repository.WorkAreaTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkAreaTypeServiceImpl implements WorkAreaTypeService {

    private final WorkAreaTypeConverter converter;
    private final WorkAreaTypeRepository repository;

    @Override
    public List<WorkAreaTypeDto> findAll() {
        val workAreaTypes = repository.findAll();
        return workAreaTypes.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
