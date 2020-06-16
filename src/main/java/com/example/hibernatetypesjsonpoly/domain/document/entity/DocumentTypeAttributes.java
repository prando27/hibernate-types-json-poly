package com.example.hibernatetypesjsonpoly.domain.document.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "documentType")
@JsonSubTypes({
        @JsonSubTypes.Type(
                value = PersonalData.PersonalDataAttributes.class,
                name = PersonalData.PERSONAL_DATA_DOCUMENT_TYPE_VALUE),

        @JsonSubTypes.Type(
                value = BankData.BankDataAttributes.class,
                name = BankData.BANK_DATA_DOCUMENT_TYPE_VALUE),
})
public abstract class DocumentTypeAttributes {

    @Getter
    private final String documentType;

    protected DocumentTypeAttributes(String documentType) {
        this.documentType = documentType;
    }
}
