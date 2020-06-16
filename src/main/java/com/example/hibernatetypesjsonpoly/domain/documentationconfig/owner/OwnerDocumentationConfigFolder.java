package com.example.hibernatetypesjsonpoly.domain.documentationconfig.owner;

import com.example.hibernatetypesjsonpoly.domain.documentationconfig.DocumentationConfigFolder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OWNER")
public class OwnerDocumentationConfigFolder extends DocumentationConfigFolder {
}
