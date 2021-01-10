package com.geo.owl.building.converter;

import com.geo.owl.building.dto.justification.ElevationMarkHistoryDto;
import com.geo.owl.building.model.ElevationMarkHistory;
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

public class ElevationMarkHistoryConverterTest {

    private static final String OBJECT_ID = "object id";
    private static final String NAME = "name";
    private static final String ELEVATION_MARK_ID = "mark";
    private static final Long VERSION = 1L;
    private static final String ELEVATION_MARK_TYPE = "type";
    private static final Timestamp MEASUREMENT_DATE = Timestamp.valueOf(now());
    private static final Double H = 3.0;

    private ElevationMarkHistoryConverter converter = new ElevationMarkHistoryConverter();

    @Test
    public void convertEntityTest() {
        val entity = entity();

        val converted = converter.convert(entity);

        assertEquals(dto(), converted);
    }

    @Test
    public void convertNullEntityTest() {
        ElevationMarkHistory history = null;

        assertNull(converter.convert(history));
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
        ElevationMarkHistoryDto dto = null;

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
        assertNotNull(converter.convert((List<ElevationMarkHistoryDto>) null));
        assertNotNull(converter.convert(emptySet()));
        assertNotNull(converter.convert((Set<ElevationMarkHistory>) null));
    }

    private ElevationMarkHistory entity() {
        return new ElevationMarkHistory()
                .setObjectId(OBJECT_ID)
                .setName(NAME)
                .setElevationMarkType(ELEVATION_MARK_TYPE)
                .setH(H)
                .setVersion(VERSION)
                .setElevationMarkId(ELEVATION_MARK_ID)
                .setMeasurementDate(MEASUREMENT_DATE);
    }

    private ElevationMarkHistoryDto dto() {
        return new ElevationMarkHistoryDto()
                .setObjectId(OBJECT_ID)
                .setName(NAME)
                .setElevationMarkType(ELEVATION_MARK_TYPE)
                .setH(H)
                .setVersion(VERSION)
                .setElevationMarkId(ELEVATION_MARK_ID)
                .setMeasurementDate(MEASUREMENT_DATE);
    }

}