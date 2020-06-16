package com.example.hibernatetypesjsonpoly.domain.documentationconfig;

import com.example.hibernatetypesjsonpoly.domain.common.BaseEntity;
import com.example.hibernatetypesjsonpoly.domain.document.entity.Document;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "documentation_config_document")
public abstract class DocumentationConfigDocument extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documentation_config_folder_id")
    private DocumentationConfigFolder documentationConfigFolder;

    // Transforma isso em coluna JSON para preservar o histórico do documento usado?
    // É válido par IDENTITY_DOC e INCOME_DATA, pois os mesmos podem mudar conforme o tempo
    // Pelo Banco, se o JOIN for feito com uma tabela _AUD usando a data da documentationConfig e pegarmos exatamente como o documento estava?
    // Essa entidade pode morrer e termos a array/lista de IDS de documentos usados da pasta
    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document<?> document;
}
