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
@Table(name = "base_points")
@Accessors(chain = true)
public class BasePoint {
    @Id
    @GeneratedValue(generator = "points_uuid2")
    @GenericGenerator(name = "points_uuid2", strategy = "uuid2")
    private String objectId;
    private String name;
    private String basePointType;
    private Double x;
    private Double y;
    private Double h;
    private Long version;
    @CreationTimestamp
    private Timestamp created;
    @UpdateTimestamp
    private Timestamp lastUpdated;

    @Version
    private long lock;
}
