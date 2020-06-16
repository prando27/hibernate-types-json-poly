package com.example.hibernatetypesjsonpoly.domain;

import com.example.hibernatetypesjsonpoly.domain.common.Result;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
public class Name {

    private String value;

    private Name(String value) {
        this();

        if (value == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        if (value.length() > 100) {
            throw new IllegalArgumentException("Name cannot have more than 100 characters");
        }

        this.value = value;
    }

    public static Result<Name> create(String value) {
        try {
            return Result.ok(new Name(value));
        } catch (Exception ex) {
            return Result.error(ex.getMessage());
        }
    }
}
