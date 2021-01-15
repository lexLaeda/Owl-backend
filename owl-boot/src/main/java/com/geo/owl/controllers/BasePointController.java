package com.geo.owl.controllers;


import com.geo.owl.building.api.BasePointApi;
import com.geo.owl.building.dto.justification.BasePointDto;
import com.geo.owl.common.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/base_points")
public class BasePointController {

    private final BasePointApi api;

    @PostMapping("/update")
    public ApiResult<BasePointDto> updateBasePoint(@RequestBody BasePointDto dto) {
        return api.updateBasePoint(dto);
    }
}
