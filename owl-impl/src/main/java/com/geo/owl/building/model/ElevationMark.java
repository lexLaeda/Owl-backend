package com.geo.owl.building.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.sql.Timestamp;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "elevation_marks")
public class ElevationMark {
    @Id
    @GeneratedValue(generator = "elevation_marks_uuid2")
    @GenericGenerator(name = "elevation_marks_uuid2", strategy = "uuid2")
    private String objectId;
    private String name;
    private String elevationMarkType;
    private Double h;
    private Long version;
    @CreationTimestamp
    private Timestamp created;
    @UpdateTimestamp
    private Timestamp lastUpdated;

    @Version
    private long lock;
}
