package com.example.hibernatetypesjsonpoly.domain.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

// Define o ID e o Equals + HashCode de todas as entities
@MappedSuperclass
@EqualsAndHashCode
@Getter
public class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
}
