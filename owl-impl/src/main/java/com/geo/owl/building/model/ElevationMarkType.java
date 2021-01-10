package com.geo.owl.building.model;

import com.geo.owl.common.model.BaseDictionary;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "elevation_mark_types")
@EqualsAndHashCode(callSuper = false)
public class ElevationMarkType extends BaseDictionary {
}
