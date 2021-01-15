package com.geo.owl.controllers;

import com.geo.owl.building.api.DictionaryApi;
import com.geo.owl.common.ApiResult;
import com.geo.owl.common.DictionaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dictionaries")
public class DictionaryController {

    private final DictionaryApi api;

    @GetMapping("/get")
    public ApiResult<DictionaryDto> getAllDictionaries() {
        return api.getAllDictionaries();
    }
}
