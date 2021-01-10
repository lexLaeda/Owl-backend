package com.geo.owl.building.repository;

import com.geo.owl.building.model.BasePoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<BasePoint, String> {
}
