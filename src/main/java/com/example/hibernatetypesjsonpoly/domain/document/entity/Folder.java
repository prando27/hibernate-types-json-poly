package com.example.hibernatetypesjsonpoly.domain.document.entity;

import com.example.hibernatetypesjsonpoly.domain.common.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "folder")
public class Folder extends BaseEntity {

    @OneToMany(mappedBy = "folder",
            cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private final List<Document<?>> documents = new ArrayList<>();

    public void addDocument(Document<?> document) {
        document.setFolder(this);
        documents.add(document);
    }

    public PersonalData getPersonalData() {
        return documents.stream()
                .filter(document -> document instanceof PersonalData)
                .map(PersonalData.class::cast)
                .findFirst()
                .orElseThrow();
    }

    public List<BankData> getBanks() {
        return documents.stream()
                .filter(document -> document instanceof BankData)
                .map(BankData.class::cast)
                .collect(Collectors.toList());
    }
}
