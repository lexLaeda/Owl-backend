package com.geo.owl.common.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@Data
@MappedSuperclass
@Accessors(chain = true)
public abstract class BaseDictionary {
    @Id
    private String code;
    private String nameRu;
    private String nameEn;

    @Version
    private long lock;
}
