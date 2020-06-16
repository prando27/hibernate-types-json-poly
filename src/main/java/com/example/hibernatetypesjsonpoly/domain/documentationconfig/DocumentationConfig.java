package com.example.hibernatetypesjsonpoly.domain.documentationconfig;

import com.example.hibernatetypesjsonpoly.domain.common.Aggregate;

import org.hibernate.annotations.DiscriminatorFormula;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "documentation_config")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorFormula(
        "case proposal_id is not null " +
        "then 'TENANT' " +
        "else 'OWNER' ")
@DiscriminatorOptions(insert = false)
public abstract class DocumentationConfig extends Aggregate {

    private Long userId;
}
