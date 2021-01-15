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
@Table(name = "base_point_histories")
public class BasePointHistory {
    @Id
    @GeneratedValue(generator = "base_point_histories_uuid2")
    @GenericGenerator(name = "base_point_histories_uuid2", strategy = "uuid2")
    public String objectId;
    private String name;
    private String basePointType;
    private Double x;
    private Double y;
    private Double h;
    private Long version;
    private Timestamp measurementDate;
    private String basePointId;

    @Version
    private long lock;
}
