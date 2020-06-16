package com.example.hibernatetypesjsonpoly.domain.documentationconfig.tenant;

import com.example.hibernatetypesjsonpoly.domain.documentationconfig.DocumentationConfigFolder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TENANT")
public class TenantDocumentationConfigFolder extends DocumentationConfigFolder {

    private String motivoLocacao;
    private Boolean vaiMorar; // Vai vir preenchido da avaliação de crédito
    private String tempoResidencia;
    private String situacaoImovelAtual;
}
