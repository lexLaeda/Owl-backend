package com.geo.owl.building.converter;

import com.geo.owl.building.dto.AddressDto;
import com.geo.owl.building.dto.BuildingObjectDto;
import com.geo.owl.building.dto.WorkAreaDto;
import com.geo.owl.building.model.Address;
import com.geo.owl.building.model.BuildingObject;
import com.geo.owl.building.model.WorkArea;
import lombok.val;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.time.LocalDateTime.now;
import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuildingObjectConverterTest {

    private static final String OBJECT_ID = "object id";
    private static final String NAME = "name";
    private static final Timestamp START_DATE = Timestamp.valueOf(now());
    private static final Timestamp END_DATE = Timestamp.valueOf(now());

    private Address address = new Address();
    private AddressDto addressDto = new AddressDto();
    private WorkArea workArea = new WorkArea();
    private WorkAreaDto workAreaDto = new WorkAreaDto();

    private WorkAreaConverter workAreaConverter;
    private AddressConverter addressConverter;

    private BuildingObjectConverter converter;

    @Before
    public void setUp() {
        workAreaConverter = mock(WorkAreaConverter.class);
        addressConverter = mock(AddressConverter.class);
        converter = new BuildingObjectConverter(addressConverter, workAreaConverter);

        when(addressConverter.convert(address)).thenReturn(addressDto);
        when(addressConverter.convert(addressDto)).thenReturn(address);
        when(workAreaConverter.convert(singleton(workArea))).thenReturn(singletonList(workAreaDto));
        when(workAreaConverter.convert(singletonList(workAreaDto))).thenReturn(singleton(workArea));
    }

    @Test
    public void convertEntityTest() {
        val entity = entity();

        val converted = converter.convert(entity);

        assertEquals(dto(), converted);
    }

    @Test
    public void convertNullEntityTest() {
        BuildingObject buildingObject = null;

        assertNull(converter.convert(buildingObject));
    }

    @Test
    public void convertToEntityCollections() {
        val dtoList = singletonList(dto());

        val converted = converter.convert(dtoList);

        assertEquals(singleton(entity()), converted);
    }

    @Test
    public void convertDtoTest() {
        val dto = dto();

        val converted = converter.convert(dto);

        assertEquals(entity(), converted);

    }

    @Test
    public void convertNullDtoTest() {
        BuildingObjectDto dto = null;

        assertNull(converter.convert(dto));
    }

    @Test
    public void convertToDtoCollections() {
        val entitySet = singleton(entity());

        val converted = converter.convert(entitySet);

        assertEquals(singletonList(dto()), converted);
    }

    @Test
    public void convertNullEmptyCollections() {
        assertNotNull(converter.convert(new ArrayList<BuildingObject>()));
        assertNotNull(converter.convert((List<BuildingObjectDto>) null));
        assertNotNull(converter.convert(emptySet()));
        assertNotNull(converter.convert((Set<BuildingObject>) null));
    }

    private BuildingObject entity() {
        return new BuildingObject()
                .setObjectId(OBJECT_ID)
                .setName(NAME)
                .setAddress(address)
                .setWorkAreas(singleton(workArea))
                .setStartDate(START_DATE)
                .setEndDate(END_DATE);
    }

    private BuildingObjectDto dto() {
        return new BuildingObjectDto()
                .setObjectId(OBJECT_ID)
                .setName(NAME)
                .setAddress(addressDto)
                .setWorkAreas(singletonList(workAreaDto))
                .setStartDate(START_DATE)
                .setEndDate(END_DATE);
    }
}