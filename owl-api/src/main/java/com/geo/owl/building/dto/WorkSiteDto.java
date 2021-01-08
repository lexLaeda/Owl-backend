package com.geo.owl.building.dto;

import com.geo.owl.building.dto.justification.BenchmarkDto;
import com.geo.owl.building.dto.justification.PointDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WorkSiteDto {
    private String objectId;
    private List<BenchmarkDto> benchmarks = new ArrayList<>();
    private List<PointDto> points = new ArrayList<>();
}
