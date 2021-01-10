package com.geo.owl.building.repository;

import com.geo.owl.building.model.ElevationMarkHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElevationMarkHistoryRepository
        extends JpaRepository<ElevationMarkHistory, String> {
}
