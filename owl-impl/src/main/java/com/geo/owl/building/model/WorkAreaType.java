package com.geo.owl.building.model;

import com.geo.owl.common.model.BaseDictionary;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "work_area_types")
@EqualsAndHashCode(callSuper = true)
public class WorkAreaType extends BaseDictionary {
}
