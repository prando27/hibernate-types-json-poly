package com.example.hibernatetypesjsonpoly.domain.document.entity;

import com.example.hibernatetypesjsonpoly.domain.common.BaseEntity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.DiscriminatorFormula;
import org.hibernate.annotations.DiscriminatorOptions;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// Construtor necessário para o Hibernate, fazer protected para evitar o uso
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Inheritance
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@DiscriminatorOptions(insert = false)
// O que diferencia cada tipo de documento durante as queries
@DiscriminatorFormula(" attributes ->> 'documentType' ")
public abstract class Document<T extends DocumentTypeAttributes> extends BaseEntity {

    // Jackson Polymorphic Deserialization
    // Utiliza o DocumentTypeAttributes e não T por problemas com o mecanismo do hibernate-types
    // Protected pois somente as subclasses devem ter acesso e expor somente o necessário
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private DocumentTypeAttributes attributes;

    protected Document(DocumentTypeAttributes attributes) {
        this.attributes = attributes;
    }

    // Qualquer subclasse já irá possuir o getAttributes com o tipo específico
    protected T getAttributes() {
        return (T) attributes;
    }

    // TODO Deixar esse atributo sem setter e fazer com que no construtor de um document a folder já seja informada
    @Setter(AccessLevel.PUBLIC)
    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;
}
