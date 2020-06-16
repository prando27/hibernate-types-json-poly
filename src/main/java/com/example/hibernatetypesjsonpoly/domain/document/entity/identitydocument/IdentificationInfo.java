package com.example.hibernatetypesjsonpoly.domain.document.entity.identitydocument;

import com.example.hibernatetypesjsonpoly.domain.Attachment;
import com.example.hibernatetypesjsonpoly.domain.document.entity.Document;
import com.example.hibernatetypesjsonpoly.domain.document.entity.DocumentTypeAttributes;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import java.time.LocalDate;
import java.util.List;

import static com.example.hibernatetypesjsonpoly.domain.document.entity.identitydocument.IdentificationInfo.IDENTIFICATION_INFO_DOCUMENT_DOCUMENT_TYPE_VALUE;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DiscriminatorValue(IDENTIFICATION_INFO_DOCUMENT_DOCUMENT_TYPE_VALUE)
public class IdentificationInfo
        extends Document<IdentificationInfo.IdentityDocumentAttributes> {

    public static final String IDENTIFICATION_INFO_DOCUMENT_DOCUMENT_TYPE_VALUE = "IDENTIFICATION_INFO";

    private IdentificationInfo(String documentNumber,
                               List<Attachment> attachments) {
        super(new IdentityDocumentAttributes(documentNumber, attachments));
    }

    public String getDocumentNumber() {
        return getAttributes().getDocumentNumber();
    }

    @Getter
    static class IdentityDocumentAttributes extends DocumentTypeAttributes {

        private IdentificationType identificationType;
        private String documentNumber;
        private LocalDate birthDate;
        private String motherName;
        private Boolean rgCpfIncluded; // Somente para RG, se não estiver incluído, tem que ter 3 anexos
        private List<Attachment> attachments;

        protected IdentityDocumentAttributes() {
            super(IDENTIFICATION_INFO_DOCUMENT_DOCUMENT_TYPE_VALUE);
        }

        private IdentityDocumentAttributes(String documentNumber,
                                           List<Attachment> attachments) {
            this();

            if (documentNumber == null || documentNumber.isEmpty()) {
                throw new IllegalArgumentException("document number cannot be null or empty");
            }

            this.documentNumber = documentNumber;
            this.attachments = attachments;
        }
    }
}
