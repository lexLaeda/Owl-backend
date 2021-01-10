package com.geo.owl.building.converter;

import com.geo.owl.building.dto.justification.BasePointDto;
import com.geo.owl.building.model.BasePoint;
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

public class BasePointConverterTest {

    private static final String OBJECT_ID = "object id";
    private static final String NAME = "name";
    private static final Long VERSION = 1L;
    private static final String POINT_TYPE = "type";
    private static final Timestamp CREATED = Timestamp.valueOf(now());
    private static final Timestamp LAST_UPDATED = Timestamp.valueOf(now());
    private static final Double X = 1.0;
    private static final Double Y = 2.0;
    private static final Double H = 3.0;

    private BasePointConverter converter = new BasePointConverter();

    @Test
    public void convertEntityTest() {
        val entity = entity();

        val converted = converter.convert(entity);

        assertEquals(dto(), converted);
    }

    @Test
    public void convertNullEntityTest() {
        BasePoint point = null;

        assertNull(converter.convert(point));
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
        BasePointDto dto = null;

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
        assertNotNull(converter.convert((List<BasePointDto>) null));
        assertNotNull(converter.convert(emptySet()));
        assertNotNull(converter.convert((Set<BasePoint>) null));
    }

    private BasePoint entity() {
        return new BasePoint()
                .setObjectId(OBJECT_ID)
                .setName(NAME)
                .setVersion(VERSION)
                .setPointType(POINT_TYPE)
                .setCreated(CREATED)
                .setLastUpdated(LAST_UPDATED)
                .setX(X)
                .setY(Y)
                .setH(H);
    }

    private BasePointDto dto() {
        return new BasePointDto()
                .setObjectId(OBJECT_ID)
                .setName(NAME)
                .setVersion(VERSION)
                .setPointType(POINT_TYPE)
                .setCreated(CREATED)
                .setLastUpdated(LAST_UPDATED)
                .setX(X)
                .setY(Y)
                .setH(H);
    }
}