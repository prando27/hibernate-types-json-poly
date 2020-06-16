package com.example.hibernatetypesjsonpoly.domain.document.entity.income;

import com.example.hibernatetypesjsonpoly.domain.Attachment;
import com.example.hibernatetypesjsonpoly.domain.document.entity.Document;
import com.example.hibernatetypesjsonpoly.domain.document.entity.DocumentTypeAttributes;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import java.util.List;
import java.util.Map;

@Entity
@DiscriminatorValue("")
public class IncomeData
        extends Document<IncomeData.IncomeDataAttributes> {

    public static final String INCOME_DATA_DOCUMENT_TYPE_VALUE = "INCOME_DATA";

    // TODO Qual a complexidade de ter subtipos mapeados aqui também?
    @Getter
    static class IncomeDataAttributes extends DocumentTypeAttributes {

        // Cada IncomeNature tem validação sobre quantos ProofOfIncome são necessários
        private IncomeNature incomeNature;

        // Somente para CLT
        private String companyName;
        private String companyPhone;

        // Cada ProofOfIncomeType tem sua validação com quantidade de Attachments
        private Map<ProofOfIncomeType, List<Attachment>> proofOfIncome;

        protected IncomeDataAttributes() {
            super(INCOME_DATA_DOCUMENT_TYPE_VALUE);
        }
    }
}
