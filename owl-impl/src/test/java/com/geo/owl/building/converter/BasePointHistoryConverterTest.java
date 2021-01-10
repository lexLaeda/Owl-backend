package com.geo.owl.building.converter;

import com.geo.owl.building.dto.justification.BasePointHistoryDto;
import com.geo.owl.building.model.BasePointHistory;
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

public class BasePointHistoryConverterTest {

    private static final String OBJECT_ID = "object id";
    private static final String NAME = "name";
    private static final String BASE_POINT_ID = "base";
    private static final Long VERSION = 1L;
    private static final String POINT_TYPE = "type";
    private static final Timestamp MEASUREMENT_DATE = Timestamp.valueOf(now());
    private static final Double X = 1.0;
    private static final Double Y = 2.0;
    private static final Double H = 3.0;

    private BasePointHistoryConverter converter = new BasePointHistoryConverter();

    @Test
    public void convertEntityTest() {
        val entity = entity();

        val converted = converter.convert(entity);

        assertEquals(dto(), converted);
    }

    @Test
    public void convertNullEntityTest() {
        BasePointHistory history = null;

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
        BasePointHistoryDto dto = null;

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
        assertNotNull(converter.convert((List<BasePointHistoryDto>) null));
        assertNotNull(converter.convert(emptySet()));
        assertNotNull(converter.convert((Set<BasePointHistory>) null));
    }

    private BasePointHistory entity() {
        return new BasePointHistory()
                .setObjectId(OBJECT_ID)
                .setName(NAME)
                .setPointType(POINT_TYPE)
                .setX(X)
                .setY(Y)
                .setH(H)
                .setVersion(VERSION)
                .setBasePointId(BASE_POINT_ID)
                .setMeasurementDate(MEASUREMENT_DATE);
    }

    private BasePointHistoryDto dto() {
        return new BasePointHistoryDto()
                .setObjectId(OBJECT_ID)
                .setName(NAME)
                .setPointType(POINT_TYPE)
                .setX(X)
                .setY(Y)
                .setH(H)
                .setVersion(VERSION)
                .setBasePointId(BASE_POINT_ID)
                .setMeasurementDate(MEASUREMENT_DATE);
    }
}