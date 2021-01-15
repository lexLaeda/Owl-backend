package com.geo.owl.building.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Accessors(chain = true)
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue(generator = "address_uuid2")
    @GenericGenerator(name = "address_uuid2", strategy = "uuid2")
    private String objectId;
    private String city;
    private String street;
    private String house;

    @Version
    private long lock;
}
