package com.example.hibernatetypesjsonpoly.domain.document.entity;

import com.example.hibernatetypesjsonpoly.domain.Attachment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import java.util.List;

import static com.example.hibernatetypesjsonpoly.domain.document.entity.BankData.BANK_DATA_DOCUMENT_TYPE_VALUE;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DiscriminatorValue(BANK_DATA_DOCUMENT_TYPE_VALUE)
public class BankData extends Document<BankData.BankDataAttributes> {

    public static final String BANK_DATA_DOCUMENT_TYPE_VALUE = "BANK_DATA";

    public BankData(String account,
                    List<Attachment> attachments) {
        super(new BankDataAttributes(account, attachments));
    }

    public String getAccount() {
        return getAttributes().account;
    }

    public List<Attachment> getAttachments() {
        return getAttributes().attachments;
    }

    @Getter
    static class BankDataAttributes extends DocumentTypeAttributes {

        private String account;
        private List<Attachment> attachments;

        protected BankDataAttributes() {
            super(BANK_DATA_DOCUMENT_TYPE_VALUE);
        }

        private BankDataAttributes(String account,
                                   List<Attachment> attachments) {
            this();
            this.account = account;
            this.attachments = attachments;
        }
    }
}
