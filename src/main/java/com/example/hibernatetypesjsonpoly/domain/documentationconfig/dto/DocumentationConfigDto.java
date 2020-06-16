package com.example.hibernatetypesjsonpoly.domain.documentationconfig.dto;

import java.util.List;

public class DocumentationConfigDto {

    private Long id;

    private Long userId;
    private String type; // PP ou IQ

    private String houseId;
    private String flowType;

    private String proposalId;
    private String proposalDate;

    private List<DocumentationConfigFolderDto> folders;
}
