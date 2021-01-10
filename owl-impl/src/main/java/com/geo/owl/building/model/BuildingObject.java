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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "building_objects")
public class BuildingObject {
    @Id
    @GeneratedValue(generator = "building_objects_uuid2")
    @GenericGenerator(name = "building_objects_uuid2", strategy = "uuid2")
    private String objectId;
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;

    @JoinColumn(name = "addressId", referencedColumnName = "objectId")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;

    @JoinColumn(name = "buildingObjectId")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<WorkArea> workAreas = new HashSet<>();

    @Version
    private int lock;
}
