package com.geo.owl.building.repository;

import com.geo.owl.building.model.BuildingObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingObjectRepository extends JpaRepository<BuildingObject, String> {
}
