package com.geo.owl.building.repository;

import com.geo.owl.building.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
