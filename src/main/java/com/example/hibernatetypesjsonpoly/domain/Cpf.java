package com.example.hibernatetypesjsonpoly.domain;

import com.example.hibernatetypesjsonpoly.domain.common.Result;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
public class Cpf {

    private String value;

    private Cpf(String value) {
        this();

        if (value == null) {
            throw new IllegalArgumentException("CPF cannot be null");
        }

        new CPFValidator().assertValid(value);

        this.value = value;
    }

    public static Result<Cpf> create(String value) {
        try {
            return Result.ok(new Cpf(value));
        } catch (IllegalArgumentException ex) {
            return Result.error(ex.getMessage());
        } catch (InvalidStateException ex) {
            return Result.error("CPF invalid");
        }
    }
}
