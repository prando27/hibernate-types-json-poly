package com.example.hibernatetypesjsonpoly.domain.documentationconfig.owner;

import com.example.hibernatetypesjsonpoly.domain.documentationconfig.DocumentationConfig;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
@DiscriminatorValue("OWNER")
public class OwnerDocumentationConfig extends DocumentationConfig {

    private String houseId;

    private String flowType;

    @OneToMany(mappedBy = "documentationConfig",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<OwnerDocumentationConfigFolder> documentationConfigFolders;
}
