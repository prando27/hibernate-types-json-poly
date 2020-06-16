package com.example.hibernatetypesjsonpoly.domain.common;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

// Tem Optimistic lock com @Version
@MappedSuperclass
public class Aggregate extends BaseEntity {

    @Version
    private Integer version;
}
