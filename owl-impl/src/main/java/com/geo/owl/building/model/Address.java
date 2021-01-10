package com.geo.owl.building.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(generator = "address_uuid2")
    @GenericGenerator(name = "address_uuid2", strategy = "uuid2")
    private String objectId;
    private String city;
    private String street;
    private String address;
    private String house;

    @Version
    private int lock;
}
