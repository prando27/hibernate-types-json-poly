package com.example.hibernatetypesjsonpoly.domain.document.entity;

import com.example.hibernatetypesjsonpoly.domain.Cpf;
import com.example.hibernatetypesjsonpoly.domain.Email;
import com.example.hibernatetypesjsonpoly.domain.Name;
import com.example.hibernatetypesjsonpoly.domain.common.Result;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import java.time.LocalDate;
import java.util.Optional;

import static com.example.hibernatetypesjsonpoly.domain.document.entity.PersonalData.PERSONAL_DATA_DOCUMENT_TYPE_VALUE;
import static java.util.Optional.ofNullable;

// Construtor necessário para o Hibernate, deixar protected para evitar o uso
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DiscriminatorValue(PERSONAL_DATA_DOCUMENT_TYPE_VALUE)
public class PersonalData
        extends Document<PersonalData.PersonalDataAttributes> {

    // Sempre definir o identificador de tipo direto na entidade
    public static final String PERSONAL_DATA_DOCUMENT_TYPE_VALUE = "PERSONAL_DATA";

    // Construtor privado para ser usado pelo método de construção estático "create"
    private PersonalData(Name fullName,
                         Email email,
                         Cpf cpf,
                         String maritalStatus,
                         String cellPhoneNumber,
                         String phoneNumber,
                         String rg,
                         LocalDate birthDate) {

        super(new PersonalDataAttributes(
                fullName,
                email,
                cpf,
                maritalStatus,
                cellPhoneNumber,
                phoneNumber,
                rg,
                birthDate));
    }

    // Expor as propriedades que fizer sentido
    public Name getFullName() {
        return getAttributes().getFullName();
    }

    // Todos os campos opcionais deve ser retornados como Optional
    public Optional<Email> getEmail() {
        return ofNullable(getAttributes().getEmail());
    }

    public Optional<Cpf> getCpf() {
        return ofNullable(getAttributes().getCpf());
    }

    public Optional<String> getMaritalStatus() {
        return ofNullable(getAttributes().getMaritalStatus());
    }

    // TODO Usar o VO Phone
    public Optional<String> getCellPhoneNumber() {
        return ofNullable(getAttributes().getCellPhoneNumber());
    }

    // TODO Usar o VO Phone
    public Optional<String> getPhoneNumber() {
        return ofNullable(getAttributes().getPhoneNumber());
    }

    public Optional<String> getRg() {
        return ofNullable(getAttributes().getRg());
    }

    public Optional<LocalDate> getBirthDate() {
        return ofNullable(getAttributes().getBirthDate());
    }

    public static Result<PersonalData> create(Name fullName,
                                              Email email,
                                              Cpf cpf,
                                              String maritalStatus,
                                              String cellPhoneNumber,
                                              String phoneNumber,
                                              String rg,
                                              LocalDate birthDate) {
        try {
            return Result.ok(new PersonalData(
                    fullName,
                    email,
                    cpf,
                    maritalStatus,
                    cellPhoneNumber,
                    phoneNumber,
                    rg,
                    birthDate
            ));
        } catch (IllegalArgumentException ex) {
            return Result.error(ex.getMessage());
        }
    }


    // Classe com os atributos da entidade, ideal que seja um Value Object (Imutável)
    // Necessário para usarmos o mecanismo JSONB do postgres mas mantermos a riqueza de domínio do tipo de documento
    @Getter
    static class PersonalDataAttributes extends DocumentTypeAttributes {

        private Name fullName;
        private Email email;
        private Cpf cpf;
        private String maritalStatus;
        private String cellPhoneNumber;
        private String phoneNumber;
        private String rg;
        private LocalDate birthDate;

        // Fazer o vínculo com o tipo de documento no construtor padrão
        protected PersonalDataAttributes() {
            super(PERSONAL_DATA_DOCUMENT_TYPE_VALUE);
        }

        private PersonalDataAttributes(Name fullName,
                                       Email email,
                                       Cpf cpf,
                                       String maritalStatus,
                                       String cellPhoneNumber,
                                       String phoneNumber,
                                       String rg,
                                       LocalDate birthDate) {
            this();

            if (fullName == null) {
                throw new IllegalArgumentException("FullName cannot be null");
            }

            this.fullName = fullName;
            this.email = email;
            this.cpf = cpf;
            this.maritalStatus = maritalStatus;
            this.cellPhoneNumber = cellPhoneNumber;
            this.phoneNumber = phoneNumber;
            this.rg = rg;
            this.birthDate = birthDate;
        }
    }
}
