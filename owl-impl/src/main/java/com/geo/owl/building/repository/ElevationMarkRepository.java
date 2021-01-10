package com.geo.owl.building.repository;

import com.geo.owl.building.model.ElevationMark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElevationMarkRepository extends JpaRepository<ElevationMark, String> {
}
