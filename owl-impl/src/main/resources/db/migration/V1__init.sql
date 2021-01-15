CREATE TABLE building_objects
(
    object_id  VARCHAR(255) PRIMARY KEY,
    name       VARCHAR(255),
    address_id VARCHAR(255),
    start_date TIMESTAMP,
    end_date   TIMESTAMP,
    address    VARCHAR(255),
    lock       BIGINT DEFAULT 0
);

CREATE TABLE address
(
    object_id VARCHAR(255) PRIMARY KEY,
    city      VARCHAR(255),
    street    VARCHAR(255),
    house     VARCHAR(255),
    lock      BIGINT DEFAULT 0
);

ALTER TABLE building_objects
    ADD CONSTRAINT FK_BUILDING_OBJECTS_2_ADDRESS
        FOREIGN KEY (address) REFERENCES address (object_id);

CREATE TABLE work_areas
(
    object_id          VARCHAR(255) PRIMARY KEY,
    name               VARCHAR(255),
    start_date         TIMESTAMP,
    end_date           TIMESTAMP,
    work_area_type     VARCHAR(255),
    building_object_id VARCHAR(255),
    lock               BIGINT DEFAULT 0
);

ALTER TABLE work_areas
    ADD CONSTRAINT FK_WORK_AREAS_2_BUILDING_OBJECTS
        FOREIGN KEY (building_object_id) REFERENCES building_objects (object_id);

CREATE TABLE work_area_types
(
    code    VARCHAR(255) PRIMARY KEY,
    name_ru VARCHAR(255),
    name_en VARCHAR(255),
    lock    BIGINT DEFAULT 0
);

ALTER TABLE work_areas
    ADD CONSTRAINT FK_WORK_AREAS_2WORK_AREA_TYPES
        FOREIGN KEY (work_area_type) REFERENCES work_area_types (code);

CREATE TABLE base_point_types
(
    code    VARCHAR(255) PRIMARY KEY,
    name_ru VARCHAR(255),
    name_en VARCHAR(255),
    lock    BIGINT DEFAULT 0
);

CREATE TABLE base_points
(
    object_id       VARCHAR(255) PRIMARY KEY,
    name            VARCHAR(255),
    base_point_type VARCHAR(255),
    x               DOUBLE PRECISION,
    y               DOUBLE PRECISION,
    h               DOUBLE PRECISION,
    version         BIGINT,
    created         TIMESTAMP,
    last_updated    TIMESTAMP,
    work_area_id    VARCHAR(255),
    lock            BIGINT DEFAULT 0
);

ALTER TABLE base_points
    ADD CONSTRAINT FK_POINTS_2_WORK_AREAS
        FOREIGN KEY (work_area_id) REFERENCES work_areas (object_id);

ALTER TABLE base_points
    ADD CONSTRAINT FK_POINTS_2_POINT_TYPES
        FOREIGN KEY (base_point_type) REFERENCES base_point_types (code);

CREATE TABLE base_point_histories
(
    object_id        VARCHAR(255) PRIMARY KEY,
    name             VARCHAR(255),
    base_point_type  VARCHAR(255),
    x                DOUBLE PRECISION,
    y                DOUBLE PRECISION,
    h                DOUBLE PRECISION,
    version          BIGINT,
    measurement_date TIMESTAMP,
    base_point_id    VARCHAR(255),
    lock             BIGINT DEFAULT 0
);

ALTER TABLE base_point_histories
    ADD CONSTRAINT FK_POINT_HISTORIES_2_POINTS
        FOREIGN KEY (base_point_id) REFERENCES base_points (object_id);

ALTER TABLE base_point_histories
    ADD CONSTRAINT FK_POINT_HISTORIES_2_POINT_TYPES
        FOREIGN KEY (base_point_type) REFERENCES base_point_types (code);

CREATE TABLE elevation_marks
(
    object_id           VARCHAR(255) PRIMARY KEY,
    name                VARCHAR(255),
    elevation_mark_type VARCHAR(255),
    h                   DOUBLE PRECISION,
    version             BIGINT,
    created             TIMESTAMP,
    last_updated        TIMESTAMP,
    work_area_id        VARCHAR(255),
    lock                BIGINT DEFAULT 0
);

ALTER TABLE elevation_marks
    ADD CONSTRAINT FK_ELEVATION_MARKS_2_WORK_AREAS
        FOREIGN KEY (work_area_id) REFERENCES work_areas (object_id);

CREATE TABLE elevation_mark_types
(
    code    VARCHAR(255) PRIMARY KEY,
    name_ru VARCHAR(255),
    name_en VARCHAR(255),
    lock    BIGINT DEFAULT 0
);

ALTER TABLE elevation_marks
    ADD CONSTRAINT FK_ELEVATION_MARKS_2_ELEVATION_MARKS_TYPES
        FOREIGN KEY (elevation_mark_type) REFERENCES elevation_mark_types (code);

CREATE TABLE elevation_mark_histories
(
    object_id           VARCHAR(255) PRIMARY KEY,
    name                VARCHAR(255),
    elevation_mark_type VARCHAR(255),
    h                   DOUBLE PRECISION,
    version             BIGINT,
    measurement_date    TIMESTAMP,
    elevation_mark_id   VARCHAR(255),
    lock                BIGINT DEFAULT 0
);

ALTER TABLE elevation_mark_histories
    ADD CONSTRAINT FK_ELEVATION_MARK_HISTORIES_2_ELEVATION_MARK_TYPES
        FOREIGN KEY (elevation_mark_type) REFERENCES elevation_mark_types (code);

ALTER TABLE elevation_mark_histories
    ADD CONSTRAINT FK_ELEVATION_MARK_HISTORIES_2_ELEVATION_MARKS
        FOREIGN KEY (elevation_mark_id) REFERENCES elevation_marks (object_id);

INSERT INTO base_point_types (code,name_ru,name_en)
VALUES ('REFLECTING_STAMP','Отражающая марка','Reflecting stamp'),
       ('POLIGONOMETRIC_SIGN','Полигонометрический знак','Poligonometric sign'),
       ('TRIANGULATION_POINT','Триангуляционный пункт','Triangulation point'),
       ('TEMPORARY_POINT','Временная точка','Temporary point'),
       ('BOUNDARY_SIGN','Межевой знак','Boundary sign'),
       ('WALL_STAMP','Настенная марка','Wall stamp');