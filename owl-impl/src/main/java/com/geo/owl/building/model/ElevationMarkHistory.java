package com.geo.owl.building.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.sql.Timestamp;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "elevation_mark_histories")
public class ElevationMarkHistory {

    @Id
    @GeneratedValue(generator = "elevation_mark_histories_uuid2")
    @GenericGenerator(name = "elevation_mark_histories_uuid2", strategy = "uuid2")
    private String objectId;
    private String name;
    private String elevationMarkType;
    private Double h;
    private Long version;
    private Timestamp measurementDate;
    private String elevationMarkId;

    @Version
    private long lock;
}
