package com.geo.owl.building.converter;

import com.geo.owl.building.dto.AddressDto;
import com.geo.owl.building.model.Address;
import lombok.val;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AddressConverterTest {

    private static final String OBJECT_ID = "object id";
    private static final String CITY = "city";
    private static final String STREET = "street";
    private static final String HOUSE = "house";

    private AddressConverter converter = new AddressConverter();

    @Test
    public void convertEntityTest() {
        val entity = address();

        val converted = converter.convert(entity);

        assertEquals(dto(), converted);
    }

    @Test
    public void convertNullEntityTest(){
        Address address = null;

        assertNull(converter.convert(address));
    }

    @Test
    public void convertDtoTest() {
        val dto = dto();

        val converted = converter.convert(dto);

        assertEquals(address(), converted);
    }

    @Test
    public void convertNullDtoTest(){
        AddressDto dto = null;

        assertNull(converter.convert(dto));
    }

    private Address address() {
        return new Address()
                .setObjectId(OBJECT_ID)
                .setCity(CITY)
                .setStreet(STREET)
                .setHouse(HOUSE);
    }

    private AddressDto dto() {
        return new AddressDto()
                .setObjectId(OBJECT_ID)
                .setCity(CITY)
                .setStreet(STREET)
                .setHouse(HOUSE);
    }
}