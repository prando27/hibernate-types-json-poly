package com.example.hibernatetypesjsonpoly.domain.documentationconfig.tenant;

import com.example.hibernatetypesjsonpoly.domain.documentationconfig.DocumentationConfig;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
@DiscriminatorValue("TENANT")
public class TenantDocumentationConfig extends DocumentationConfig {

    private String proposalId;

    private String proposalDate;

    @OneToMany(mappedBy = "documentationConfig",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<TenantDocumentationConfigFolder> documentationConfigFolders;
}
