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
@Table(name = "base_point_types")
@EqualsAndHashCode(callSuper = true)
public class BasePointType extends BaseDictionary {
}
