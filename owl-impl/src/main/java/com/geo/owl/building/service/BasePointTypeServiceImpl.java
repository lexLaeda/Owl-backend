package com.geo.owl.building.service;

import com.geo.owl.building.converter.BasePointTypeConverter;
import com.geo.owl.building.dto.justification.BasePointTypeDto;
import com.geo.owl.building.repository.BasePointTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BasePointTypeServiceImpl implements BasePointTypeService {

    private final BasePointTypeConverter converter;
    private final BasePointTypeRepository repository;

    @Override
    public List<BasePointTypeDto> findAll() {
        val basePointTypes = repository.findAll();
        return basePointTypes.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
