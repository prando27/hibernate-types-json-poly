package com.example.hibernatetypesjsonpoly.domain.documentationconfig.dto;

import java.util.Map;

public class DocumentationConfigFolderDto {

    private Long folderId;

    // Somente IQ
    private String motivoLocacao;
    private Boolean vaiMorar;
    private String tempoResidencia;
    private String situacaoImovelAtual;

    // Mapa de tipo para documento (Deve incluir
    private Map<String, DocumentDto> referencedDocuments;
}
