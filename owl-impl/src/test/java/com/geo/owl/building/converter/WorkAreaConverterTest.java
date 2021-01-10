package com.geo.owl.building.converter;

import com.geo.owl.building.dto.WorkAreaDto;
import com.geo.owl.building.dto.justification.BasePointDto;
import com.geo.owl.building.dto.justification.ElevationMarkDto;
import com.geo.owl.building.model.BasePoint;
import com.geo.owl.building.model.ElevationMark;
import com.geo.owl.building.model.WorkArea;
import lombok.val;
import org.junit.Before;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WorkAreaConverterTest {

    private static final String OBJECT_ID = "object id";
    private static final String NAME = "name";
    private static final String WORK_AREA_TYPE = "type";
    private static final Timestamp START_DATE = Timestamp.valueOf(now());
    private static final Timestamp END_DATE = Timestamp.valueOf(now());

    private BasePoint basePoint = new BasePoint();
    private BasePointDto basePointDto = new BasePointDto();
    private ElevationMark elevationMark = new ElevationMark();
    private ElevationMarkDto elevationMarkDto = new ElevationMarkDto();

    private ElevationMarkConverter elevationMarkConverter;
    private BasePointConverter basePointConverter;
    private WorkAreaConverter converter;

    @Before
    public void setUp() {
        elevationMarkConverter = mock(ElevationMarkConverter.class);
        basePointConverter = mock(BasePointConverter.class);
        converter = new WorkAreaConverter(basePointConverter, elevationMarkConverter);
        when(basePointConverter.convert(singleton(basePoint)))
                .thenReturn(singletonList(basePointDto));
        when(basePointConverter.convert(singletonList(basePointDto)))
                .thenReturn(singleton(basePoint));
        when(elevationMarkConverter.convert(singleton(elevationMark)))
                .thenReturn(singletonList(elevationMarkDto));
        when(elevationMarkConverter.convert(singletonList(elevationMarkDto)))
                .thenReturn(singleton(elevationMark));
    }

    @Test
    public void convertEntityTest() {
        val entity = entity();

        val converted = converter.convert(entity);

        assertEquals(dto(), converted);
    }

    @Test
    public void convertNullEntityTest() {
        WorkArea workArea = null;

        assertNull(converter.convert(workArea));
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
        WorkAreaDto dto = null;

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
        assertNotNull(converter.convert((List<WorkAreaDto>) null));
        assertNotNull(converter.convert(emptySet()));
        assertNotNull(converter.convert((Set<WorkArea>) null));
    }

    private WorkArea entity() {
        return new WorkArea()
                .setObjectId(OBJECT_ID)
                .setName(NAME)
                .setStartDate(START_DATE)
                .setEndDate(END_DATE)
                .setBasePoints(singleton(basePoint))
                .setElevationMarks(singleton(elevationMark))
                .setWorkAreaType(WORK_AREA_TYPE);
    }

    private WorkAreaDto dto() {
        return new WorkAreaDto()
                .setObjectId(OBJECT_ID)
                .setName(NAME)
                .setStartDate(START_DATE)
                .setEndDate(END_DATE)
                .setBasePoints(singletonList(basePointDto))
                .setElevationMarks(singletonList(elevationMarkDto))
                .setWorkAreaType(WORK_AREA_TYPE);
    }
}