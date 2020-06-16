package com.example.hibernatetypesjsonpoly.infrastructure.persistence.jackson;

import com.example.hibernatetypesjsonpoly.domain.Cpf;
import com.example.hibernatetypesjsonpoly.domain.Email;
import com.example.hibernatetypesjsonpoly.domain.Name;
import com.example.hibernatetypesjsonpoly.infrastructure.common.jackson.serializer.CpfSerializer;
import com.example.hibernatetypesjsonpoly.infrastructure.common.jackson.serializer.EmailSerializer;
import com.example.hibernatetypesjsonpoly.infrastructure.common.jackson.serializer.NameSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.vladmihalcea.hibernate.type.util.ObjectMapperSupplier;

import java.util.TimeZone;

public class CustomObjectMapperSupplier implements ObjectMapperSupplier {

    @Override
    public ObjectMapper get() {
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

        objectMapper.setTimeZone(
                TimeZone.getTimeZone("GMT")
        );

        objectMapper.registerModule(buildValueObjectModel());

        return objectMapper;
    }

    private SimpleModule buildValueObjectModel() {
        SimpleModule valueObjectsModule = new SimpleModule();
        valueObjectsModule.addSerializer(Name.class, new NameSerializer());
        valueObjectsModule.addSerializer(Cpf.class, new CpfSerializer());
        valueObjectsModule.addSerializer(Email.class, new EmailSerializer());

        return valueObjectsModule;
    }
}
