package com.example.hibernatetypesjsonpoly.domain;

import com.example.hibernatetypesjsonpoly.domain.common.Result;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

// ValueObject deve ter o construtor No-args protected para o hibernate, getters e equals e hashcode com base em todos os campos
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
public class Email {

    private String value;

    private Email(String value) {
        this();

        if (value == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        // Perform email validation

        this.value = value;
    }

    public static Result<Email> create(String value) {
        try {
            return Result.ok(new Email(value));
        } catch (IllegalStateException ex) {
            return Result.error("Invalid Email");
        }
    }
}
