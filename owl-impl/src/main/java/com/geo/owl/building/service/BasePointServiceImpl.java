package com.geo.owl.building.service;

import com.geo.owl.building.converter.BasePointConverter;
import com.geo.owl.building.dto.justification.BasePointDto;
import com.geo.owl.building.repository.BasePointRepository;
import com.geo.owl.common.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class BasePointServiceImpl implements BasePointService {

    private final BasePointRepository repository;
    private final BasePointConverter converter;


    @Override
    public BasePointDto updateBasePoint(BasePointDto dto) {
        validateUpdate(dto);
        val converted = converter.convert(dto);
        val saved = repository.saveAndFlush(converted);
        return converter.convert(saved);
    }


    public void validateUpdate(BasePointDto dto){
        val id  = dto.getObjectId();
        if (isNull(id)){
            throw new ValidationException("BasePoint id is null");
        }
        val fromDb = repository.findById(id);
        if (fromDb.isPresent()){
            return;
        }
        throw new ValidationException(String.format("Point with id %s not found", id));
    }

}
