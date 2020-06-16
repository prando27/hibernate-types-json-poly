package com.example.hibernatetypesjsonpoly.domain.documentationconfig;

import com.example.hibernatetypesjsonpoly.domain.common.BaseEntity;
import com.example.hibernatetypesjsonpoly.domain.document.entity.Folder;

import org.hibernate.annotations.DiscriminatorFormula;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "documentation_config_folder")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorFormula(
        "case vai_morar is not null " +
        "then 'TENANT' " +
        "else 'OWNER")
@DiscriminatorOptions(insert = false)
public class DocumentationConfigFolder extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documentation_config_id")
    private DocumentationConfig documentationConfig;

    // TODO Sempre trazer na query do TenantDocumentationConfig
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id")
    private Folder folder;

    // TODO Aqui podemos ter somente os Ids dos documentos referenciados pela pasta acima
    @OneToMany(mappedBy = "documentationConfigFolder",
            cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DocumentationConfigDocument> documentationConfigDocuments;
}
