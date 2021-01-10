package com.geo.owl.building.converter;

import com.geo.owl.building.dto.justification.ElevationMarkDto;
import com.geo.owl.building.model.ElevationMark;
import lombok.val;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import static java.time.LocalDateTime.now;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ElevationMarkConverterTest {
    private static final String OBJECT_ID = "object id";
    private static final String NAME = "name";
    private static final Long VERSION = 1L;
    private static final String ELEVATION_MARK_TYPE = "type";
    private static final Timestamp CREATED = Timestamp.valueOf(now());
    private static final Timestamp LAST_UPDATED = Timestamp.valueOf(now());
    private static final Double H = 3.0;

    private ElevationMarkConverter converter = new ElevationMarkConverter();

    @Test
    public void convertEntityTest() {
        val entity = entity();

        val converted = converter.convert(entity);

        assertEquals(dto(), converted);
    }

    @Test
    public void convertNullEntityTest() {
        ElevationMark elevationMark = null;

        assertNull(converter.convert(elevationMark));
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
        ElevationMarkDto dto = null;

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
        assertNotNull(converter.convert(emptyList()));
        assertNotNull(converter.convert((List<ElevationMarkDto>) null));
        assertNotNull(converter.convert(emptySet()));
        assertNotNull(converter.convert((Set<ElevationMark>) null));
    }

    private ElevationMark entity() {
        return new ElevationMark()
                .setObjectId(OBJECT_ID)
                .setName(NAME)
                .setVersion(VERSION)
                .setElevationMarkType(ELEVATION_MARK_TYPE)
                .setCreated(CREATED)
                .setLastUpdated(LAST_UPDATED)
                .setH(H);
    }

    private ElevationMarkDto dto() {
        return new ElevationMarkDto()
                .setObjectId(OBJECT_ID)
                .setName(NAME)
                .setVersion(VERSION)
                .setElevationMarkType(ELEVATION_MARK_TYPE)
                .setCreated(CREATED)
                .setLastUpdated(LAST_UPDATED)
                .setH(H);
    }

}