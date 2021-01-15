package com.geo.owl.building.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "work_areas")
@Accessors(chain = true)
public class WorkArea {
    @Id
    @GeneratedValue(generator = "work_areas_uuid2")
    @GenericGenerator(name = "work_areas_uuid2", strategy = "uuid2")
    private String objectId;
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;
    private String workAreaType;

    @JoinColumn(name = "workAreaId")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BasePoint> basePoints = new HashSet<>();

    @JoinColumn(name = "workAreaId")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ElevationMark> elevationMarks = new HashSet<>();

    @Version
    private long lock;
}
