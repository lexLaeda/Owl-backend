package com.geo.owl.building.converter;

import com.geo.owl.building.dto.WorkAreaTypeDto;
import com.geo.owl.building.model.WorkAreaType;
import lombok.val;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class WorkAreaTypeConverterTest {

    private static final String CODE = "code";
    private static final String NAME_EN = "name en";
    private static final String NAME_RU = "name ru";

    private WorkAreaTypeConverter converter = new WorkAreaTypeConverter();

    @Test
    public void convertEntityTest() {
        val entity = entity();

        val converted = converter.convert(entity);

        assertEquals(dto(), converted);
    }

    @Test
    public void convertNullEntityTest() {
        WorkAreaType workAreaType = null;

        assertNull(converter.convert(workAreaType));
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
        WorkAreaTypeDto dto = null;

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
        assertNotNull(converter.convert((List<WorkAreaTypeDto>) null));
        assertNotNull(converter.convert(emptySet()));
        assertNotNull(converter.convert((Set<WorkAreaType>) null));
    }

    private WorkAreaType entity() {
        return (WorkAreaType) new WorkAreaType()
                .setCode(CODE)
                .setNameEn(NAME_EN)
                .setNameRu(NAME_RU);
    }

    private WorkAreaTypeDto dto() {
        return (WorkAreaTypeDto) new WorkAreaTypeDto()
                .setCode(CODE)
                .setNameEn(NAME_EN)
                .setNameRu(NAME_RU);
    }

}