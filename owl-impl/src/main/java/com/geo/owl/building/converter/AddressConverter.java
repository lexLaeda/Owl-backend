package com.geo.owl.building.converter;

import com.geo.owl.building.dto.AddressDto;
import com.geo.owl.building.model.Address;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class AddressConverter {
    public AddressDto convert(Address address) {
        if (isNull(address)) {
            return null;
        }
        return new AddressDto()
                .setObjectId(address.getObjectId())
                .setCity(address.getCity())
                .setStreet(address.getStreet())
                .setHouse(address.getHouse());
    }

    public Address convert(AddressDto dto) {
        if (isNull(dto)) {
            return null;
        }
        return new Address()
                .setObjectId(dto.getObjectId())
                .setCity(dto.getCity())
                .setStreet(dto.getStreet())
                .setHouse(dto.getHouse());
    }
}
