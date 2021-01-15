package com.geo.owl.building.service;

import com.geo.owl.common.DictionaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DictionaryComposeServiceImpl implements DictionaryComposeService {

    private final BasePointTypeService basePointTypeService;
    private final ElevationMarkTypeService elevationMarkTypeService;
    private final WorkAreaTypeService workAreaTypeService;

    @Override
    public DictionaryDto getAllDictionaries() {
        return DictionaryDto.builder()
                .basePointTypes(basePointTypeService.findAll())
                .elevationMarkTypes(elevationMarkTypeService.findAll())
                .workAreaTypes(workAreaTypeService.findAll())
                .build();
    }
}
